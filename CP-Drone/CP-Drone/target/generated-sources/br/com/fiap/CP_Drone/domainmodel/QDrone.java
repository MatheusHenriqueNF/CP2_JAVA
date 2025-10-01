package br.com.fiap.CP_Drone.domainmodel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDrone is a Querydsl query type for Drone
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDrone extends EntityPathBase<Drone> {

    private static final long serialVersionUID = -1429892712L;

    public static final QDrone drone = new QDrone("drone");

    public final NumberPath<Integer> capacityBattery = createNumber("capacityBattery", Integer.class);

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final ListPath<Mission, QMission> missions = this.<Mission, QMission>createList("missions", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath model = createString("model");

    public final StringPath status = createString("status");

    public QDrone(String variable) {
        super(Drone.class, forVariable(variable));
    }

    public QDrone(Path<? extends Drone> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDrone(PathMetadata metadata) {
        super(Drone.class, metadata);
    }

}

