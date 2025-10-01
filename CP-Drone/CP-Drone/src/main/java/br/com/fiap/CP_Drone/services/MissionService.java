package br.com.fiap.CP_Drone.services;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import br.com.fiap.CP_Drone.domainmodel.Mission;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MissionService {

    List<Mission> findAll();

    public Optional<Mission> findById(UUID id);

    public Mission create(Mission mission);

    public boolean existsById(UUID id);

    public void delete(Mission mission);

   public void deleteById(UUID id);

    public Mission partialUpdate(UUID id, Mission Mission);

    public List<Mission> findByDroneId_Id(UUID droneId);

    //List<? extends Mission> findAllByLocalozation(String localization);

    //List<? extends Mission> findAllByDescription(String description);


}
