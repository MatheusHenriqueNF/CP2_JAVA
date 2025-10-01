package br.com.fiap.CP_Drone.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="MISSION")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Setter @Getter UUID id;

    @Column (name = "DESCRIPTION", length = 100, nullable = false)
    private @Setter @Getter String description;

    @Column (name = "LOCALIZATION", length = 50, nullable = false)
    private @Setter @Getter String localization;

    @Column (name = "DATE_AGENDA", nullable = false)
    private @Setter @Getter LocalDate dateAgenda;

    @ManyToOne
    @JoinColumn (name = "Drone_ID", nullable = false)
    private @Setter @Getter Drone droneId;

    @Column (name = "USAGE_BATTERY", nullable = false)
    private @Setter @Getter Integer usageBattery;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Objects.equals(id, mission.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", localization='" + localization + '\'' +
                ", dateAgenda=" + dateAgenda +
                ", droneID=" + droneId +
                ", usageBattery=" + usageBattery +
                '}';
    }
}
