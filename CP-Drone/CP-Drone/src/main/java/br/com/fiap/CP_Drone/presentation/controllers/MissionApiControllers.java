package br.com.fiap.CP_Drone.presentation.controllers;

import br.com.fiap.CP_Drone.domainmodel.Mission;
import br.com.fiap.CP_Drone.presentation.transferObjects.MissionDTO;
import br.com.fiap.CP_Drone.services.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mission")
@RequiredArgsConstructor
@Tag(name = "Mission", description = "Missões de drones")
public class MissionApiControllers {

    private final MissionService missionService;

    @Operation(summary = "Insere nova missão", method = "POST")
    @PostMapping
    public ResponseEntity<MissionDTO> save(@Valid @RequestBody MissionDTO missionDTO){
        Mission newMission = this.missionService.create(MissionDTO.toEntity(missionDTO));
        return new ResponseEntity<>(MissionDTO.fromEntity(newMission), HttpStatus.CREATED);
    }

    @Operation(summary = "Listar missão por id", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> findById(@PathVariable("id") UUID id){
        return this.missionService.findById(id)
                .map(mission -> ResponseEntity.ok(MissionDTO.fromEntity(mission)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Lista o objeto de missões")
    @GetMapping
    public ResponseEntity<List<Mission>> findAll() {
        return ResponseEntity.ok(this.missionService.findAll());
    }

    @Operation(summary = "Lista todas as missões relacionadas a um drone")
    @GetMapping("/mission-drone/{droneId}")
    public List<MissionDTO> getMissionsByDrone(@PathVariable("droneId") UUID droneId) {
        return missionService.findByDroneId_Id(droneId)
                .stream()
                .map(MissionDTO::fromEntity)
                .toList();
    }

}
