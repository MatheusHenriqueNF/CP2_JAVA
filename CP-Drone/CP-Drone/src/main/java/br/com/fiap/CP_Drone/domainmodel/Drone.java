package br.com.fiap.CP_Drone.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="DRONE")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Setter
    @Getter UUID id;

    @Column(name="MODEL", length = 100, nullable = false)
    private @Setter @Getter String model;

    @Column (name="CAPACITY_BATTERY", length = 10, nullable = false)
    private @Setter @Getter int capacityBattery;

    @Column (name="STATUS", length = 50, nullable = false)
    private @Setter @Getter String status;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Drone drone = (Drone) o;
        return Objects.equals(id, drone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @OneToMany(mappedBy = "droneId")
    private List<Mission> missions = new ArrayList<Mission>();

    public Drone(UUID id) {
        this.id = id;
    }

    public Drone(String model, int capacityBattery, String status) {
        this.model = model;
        this.capacityBattery = capacityBattery;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", capacityBattery=" + capacityBattery +
                ", status=" + status +
                '}';
    }


}
