package br.com.fiap.CP_Drone.services;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import br.com.fiap.CP_Drone.domainmodel.repository.DroneRepository;
import br.com.fiap.CP_Drone.presentation.transferObjects.DroneRankingDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    //private MissionRepository missionRepository;

    @Override
    public List<Drone> findAll(){
        return new ArrayList<>
                (this.droneRepository.findAll());
    }

    @Override
    public Optional<Drone> findById(UUID id){
        return this.droneRepository.findById(id);
    }

    @Override
    public Drone create(Drone drone) {
        return this.droneRepository.save(drone);
    }

    @Override
    public boolean existsById(UUID id){
        return this.droneRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id){
        this.droneRepository.deleteById(id);
    }

    @Override
    public void delete(Drone drone){
        this.droneRepository.deleteById(drone.getId());
    }

    @Override
    public Drone partialUpdate(UUID id, Drone drone){
        if(!this.droneRepository.existsById(id))
            throw new EntityNotFoundException("Drone with id " + id + " not found");
        Drone droneFromDatabase = this.droneRepository.findById(id).orElse(null);

        if(!droneFromDatabase.getModel().equals(drone.getModel()))
            droneFromDatabase.setModel(drone.getModel());
        if(droneFromDatabase.getCapacityBattery() != drone.getCapacityBattery())
           droneFromDatabase.setCapacityBattery(drone.getCapacityBattery());
        if(!droneFromDatabase.getStatus().equals(drone.getStatus()))
            droneFromDatabase.setStatus(drone.getStatus());

        return this.create(droneFromDatabase);
    }

    /*
    @Override
    public List<? extends Drone> findAllByModel(String model){
        List<Drone> drone = new LinkedList<>();
        drone.addAll(this.droneRepository.findByDrone_Model(model));
        return drone;
    }*/

    /*@Override
    public Page<Drone> findAllPaged(Pageable pageable){
        return this.droneRepository.findAll(pageable);
    }

     */

   /* public Collection<Post> getAllPostsFromUser(Drone drone){
        return drone.getPosts();
    }*/

    @Override
    public List<DroneRankingDTO> findDroneRanking() {
        return this.droneRepository.findDroneRanking();
    }

    @Override
    public Double findMediumBattery(UUID droneId) {

        if (!droneRepository.existsById(droneId)) {
            throw new IllegalArgumentException("Drone not found");
        }

        Optional<Double> optionalAverage = this.droneRepository.findMediumBattery(droneId);

        return optionalAverage.orElse(0.0);
    }
}
