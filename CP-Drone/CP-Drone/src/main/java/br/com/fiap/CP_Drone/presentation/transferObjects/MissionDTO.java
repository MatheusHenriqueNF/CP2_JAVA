package br.com.fiap.CP_Drone.presentation.transferObjects;

import br.com.fiap.CP_Drone.domainmodel.Drone;
import br.com.fiap.CP_Drone.domainmodel.Mission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {

    private UUID id;

    @NotBlank(message = "This field required")
    @Size(max = 100, message = "descrição deve conter no máximo 100 caracteres")
    private String description;

    @NotBlank(message = "This field required")
    @Size(max = 50, message = "Localização deve conter no máximo 100 caracteres")
    private String localization;

    @NotNull(message = "This field required")
    private LocalDate dateAgenda;

    @NotNull(message = "This field required")
    private UUID droneId;


    private Integer usageBattery;

    public static MissionDTO fromEntity(Mission mission) {
        if (mission == null)
            return null;
        return MissionDTO.builder()
                .id(mission.getId())
                .description(mission.getDescription())
                .localization(mission.getLocalization())
                .dateAgenda(mission.getDateAgenda())
                .droneId(mission.getDroneId()!= null ? mission.getDroneId().getId() : null)
                .usageBattery(mission.getUsageBattery())
                .build();

    }

    public static Mission toEntity(MissionDTO dto) {
        if (dto == null)
            return null;
        return Mission.builder()
                .id(dto.id)
                .description(dto.getDescription())
                .localization(dto.getLocalization())
                .dateAgenda((dto.getDateAgenda()))
                .droneId(dto.getDroneId() != null ? new Drone(dto.getDroneId()) : null)
                .usageBattery(dto.getUsageBattery())
                .build();
    }
}
