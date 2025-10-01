package br.com.fiap.CP_Drone.presentation.controllers;


import br.com.fiap.CP_Drone.domainmodel.Drone;
import br.com.fiap.CP_Drone.presentation.transferObjects.DroneDTO;
import br.com.fiap.CP_Drone.presentation.transferObjects.DroneRankingDTO;
import br.com.fiap.CP_Drone.services.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/drone")
@Tag(name = "Drones", description = "Operacões relacionadas a controle de drones")
public class DroneApiControllers {

    private final DroneService droneService;

    @Operation(summary = "Listar todos os drones", method = "GET")
    @GetMapping
    public ResponseEntity<List<Drone>> findAll() {
        return ResponseEntity.ok(droneService.findAll());
    }

    @Operation(summary = "Listar drone por id", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<DroneDTO> findById(@PathVariable("id") UUID id){
        return this.droneService.findById(id)
                .map(drone -> ResponseEntity.ok(DroneDTO.fromEntity(drone)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Insere novo drone", method = "POST")
    @PostMapping
    public ResponseEntity<DroneDTO> save( @Valid @RequestBody DroneDTO droneDTO){
        Drone newDrone = this.droneService.create(DroneDTO.toEntity(droneDTO));
        return new ResponseEntity<>(DroneDTO.fromEntity(newDrone), HttpStatus.CREATED);
    }

    @Operation(summary = "Remove um drone pelo ID", method = "DELETE")
    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestBody UUID id){
        if( !this.droneService.existsById(id ))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone not found");
        this.droneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remove um drone inteiro", method = "DELETE")
    @DeleteMapping("/removeObject")
    public ResponseEntity<Void> delete(@RequestBody DroneDTO drone){
        if(!this.droneService.existsById(drone.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone not found");
        this.droneService.delete(DroneDTO.toEntity(drone));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza um drone inteiro", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<DroneDTO> update(@PathVariable("id") UUID id, @Valid @RequestBody DroneDTO userDto){
        if( !this.droneService.existsById(id) )
            return ResponseEntity.notFound().build();
        Drone user = DroneDTO.toEntity(userDto);
        user.setId(id);
        return new ResponseEntity<>(
                DroneDTO.fromEntity(this.droneService.create(user)),
                HttpStatus.CREATED
        );
    }

    //Não está funcionando
    @Operation(summary = "Atualiza parcialmente o drone", method = "PATCH")
    @PatchMapping("/{id}")
    public ResponseEntity<DroneDTO> partialUpdate(@PathVariable("id") UUID id, @Valid @RequestBody DroneDTO droneDto) {
        Drone updatedDrone = null;
        try {
            updatedDrone = this.droneService.findById(droneDto.getId()).orElse(null);
            return new ResponseEntity<>(
                    DroneDTO.fromEntity(updatedDrone),
                    HttpStatus.CREATED
            );
        } catch (IllegalArgumentException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Busca drone pelo modelo", method = "GET")
    @GetMapping("/model")
    public ResponseEntity<List<DroneDTO>> findAllByName(@RequestParam String model){
        return null;
    }

/*
    @Operation(summary = "Busca drone pelo modelo parametrizado", method = "GET")
    @GetMapping("/")
    public ResponseEntity<List<DroneDTO>> findAllByEmail(@RequestParam String model){

        return ResponseEntity.ok(
                new ArrayList<>(
                        this.droneService.findAllByModel(model)
                                .stream()
                                .map(DroneDTO::fromEntity)
                                .toList()));

    }
*/
    /*
    @Operation(summary = "Busca todos os drones paginados", method = "GET")
    @GetMapping("paged")
    public ResponseEntity<Page<DroneDTO>> findAllPaged(Pageable pageable){
        return ResponseEntity.ok(
                this.droneService.findAllPaged(pageable)
                        .map(DroneDTO::fromEntity)
        );
    }
*/

    @Operation(summary = "Drone battery by id", method = "GET")
    @GetMapping("/{id}/battery-drone")
    public ResponseEntity<Double> findAverageBatteryUsage(@PathVariable("id") UUID id) {
        Double average = droneService.findMediumBattery(id);
        return ResponseEntity.ok(average);
    }

    @Operation(summary = "Ranking of drones by mission", method = "GET")
    @GetMapping("ranking")
    public ResponseEntity<List<DroneRankingDTO>>  findDroneRanking() {
        List<DroneRankingDTO> ranking = droneService.findDroneRanking();
        return ResponseEntity.ok(ranking);
    }


}
