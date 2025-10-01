package br.com.fiap.CP_Drone.domainmodel.repository;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DroneRepository extends JpaRepository<Drone, UUID>,
        QuerydslPredicateExecutor<Drone>,
        DroneRepositoryCustom{


    //List<Drone> findByDrone_Id(UUID id);
    //List<Drone> findByDrone_Model(String model);
    //<Drone> findByDrone_Battery(String capacityBattery);
    //List<Drone> findByDrone_Status(String status);


    //List<Drone> id(UUID id);
}
