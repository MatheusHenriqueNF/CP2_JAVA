package br.com.fiap.CP_Drone.services;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import br.com.fiap.CP_Drone.presentation.transferObjects.DroneRankingDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DroneService {
    public List<Drone> findAll();

    public Optional<Drone> findById(UUID id);

    public Drone create(Drone drone);

    public boolean existsById(UUID id);

    public void delete(Drone drone);

    public void deleteById(UUID id);

    public Drone partialUpdate(UUID id, Drone drone);

   // List<? extends Drone> findAllByModel(String model);

    //public Page<Drone> findAllPaged(Pageable pageable);

    public List<DroneRankingDTO> findDroneRanking();

    public Double findMediumBattery(UUID droneId);

}
