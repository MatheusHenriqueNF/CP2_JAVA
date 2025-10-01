package br.com.fiap.CP_Drone.domainmodel.repository;

import br.com.fiap.CP_Drone.domainmodel.Mission;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MissionRepository extends JpaRepository<Mission,UUID> {

    //List<Mission> findByDrone_Desciption(String description);
    //List<Mission> findByDrone_Localization(String localization);
    //List<Mission> findByDrone_DateAgenda(String dateAgenda);

    List<Mission> findByDroneId_Id(UUID droneId);


    //@Query("SELECT m FROM Mission m WHERE m.drone.id = :id")
    //List<Mission> findByDrone_Id(@Param("id") UUID id);

    //@Query(value = "SELECT * FROM MISSION m WHERE m.drone_id = :id", nativeQuery = true)
    //List<Mission> findByDrone_Id(@Param("id") UUID id);
    
}
