package br.com.fiap.CP_Drone.presentation.transferObjects;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDTO {


    private UUID id;

   //@NotBlank(message = "Modelo é obrigatório")
   //@Size(min = 5, max = 100, message = "modelo deve conter no máximo 100 caracteres")
   private String model;

   //@NotBlank(message = "Capaciade da bateria é obrigatório")
   //@Min(value = 1, message = "Capacidade da bateria deve ser no mínimo 1%")
   //@Max(value = 100, message = "Capacidade da bateria deve ser no máximo 100%")
   private int capacityBattery;

   //@NotBlank(message = "Status é obrigatório")
   //@Size(min = 10, max = 50, message = "Status inválido")
   private  String status;


   public static DroneDTO fromEntity(Drone drone) {
       if (drone == null)
           return null;
       return DroneDTO.builder()
               .id(drone.getId())
               .model(drone.getModel())
               .capacityBattery(drone.getCapacityBattery())
               .status(drone.getStatus())
               .build();
   }

    public static Drone toEntity(DroneDTO dto) {
        if (dto == null)
            return null;
        return Drone.builder()
                .id(dto.id)
                .model(dto.getModel())
                .capacityBattery(dto.getCapacityBattery())
                .status(dto.getStatus())
                .build();
    }

}
