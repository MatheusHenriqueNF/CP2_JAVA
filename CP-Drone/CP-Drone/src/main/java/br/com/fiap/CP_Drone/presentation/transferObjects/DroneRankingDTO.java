package br.com.fiap.CP_Drone.presentation.transferObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneRankingDTO {

    private UUID droneId;
    private String model;
    private long totalMissions;


}
