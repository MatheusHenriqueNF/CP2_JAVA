package br.com.fiap.CP_Drone.domainmodel.repository;

import br.com.fiap.CP_Drone.presentation.transferObjects.DroneRankingDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DroneRepositoryCustom {
    Optional<Double> findMediumBattery(UUID droneId);
    List<DroneRankingDTO> findDroneRanking();
}
