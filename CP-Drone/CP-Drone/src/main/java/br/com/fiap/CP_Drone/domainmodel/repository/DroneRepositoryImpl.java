package br.com.fiap.CP_Drone.domainmodel.repository;

import br.com.fiap.CP_Drone.domainmodel.QMission;
import br.com.fiap.CP_Drone.presentation.transferObjects.DroneRankingDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static br.com.fiap.CP_Drone.domainmodel.QDrone.drone;
import static br.com.fiap.CP_Drone.domainmodel.QMission.mission;


public class DroneRepositoryImpl implements DroneRepositoryCustom {
    @PersistenceContext
    @Setter private EntityManager em;

    @Override
    public Optional<Double>findMediumBattery(UUID droneId){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QMission mission = QMission.mission;
        Double result = jpaQueryFactory
                .select(mission.usageBattery.avg())
                .from(mission)
                .where(mission.droneId.id.eq(droneId))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public List<DroneRankingDTO> findDroneRanking() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        return jpaQueryFactory

                .select(Projections.constructor(DroneRankingDTO.class,
                        drone.id,
                        drone.model,
                        mission.id.count()
                ))
                .from(mission)
                .join(mission.droneId, drone)
                .groupBy(drone.id, drone.model)
                .orderBy(mission.id.count().desc())
                .fetch();
    }
}

