package br.com.fiap.CP_Drone.services;


import br.com.fiap.CP_Drone.domainmodel.Mission;
import br.com.fiap.CP_Drone.domainmodel.repository.MissionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findAll(){
        return new ArrayList<>
                (this.missionRepository.findAll());
    }

    @Override
    public Optional<Mission> findById(UUID id){
        return this.missionRepository.findById(id);
    }

    @Override
    public Mission create(Mission mission) {
        return this.missionRepository.save(mission);
    }

    @Override
    public boolean existsById(UUID id){
        return this.missionRepository.existsById(id);
    }

    @Override
    public void deleteById(UUID id){
        this.missionRepository.deleteById(id);
    }

    @Override
    public void delete(Mission mission){
        this.missionRepository.deleteById(mission.getId());
    }

    @Override
    public Mission partialUpdate(UUID id, Mission mission){
        if(!this.missionRepository.existsById(id))
            throw new EntityNotFoundException("Mission with id " + id + " not found");
        Mission missionFromDatabase = this.missionRepository.findById(id).orElse(null);

        if(!missionFromDatabase.getDescription().equals(mission.getDescription()))
            missionFromDatabase.setDescription(mission.getDescription());
        if(!missionFromDatabase.getLocalization().equals(mission.getLocalization()))
            missionFromDatabase.setLocalization(mission.getLocalization());
        if(!missionFromDatabase.getDateAgenda().equals(mission.getDateAgenda()))
            missionFromDatabase.setDateAgenda(mission.getDateAgenda());

        return this.create(missionFromDatabase);
    }

    @Override
    public List<Mission> findByDroneId_Id(UUID droneId){
        return missionRepository.findByDroneId_Id(droneId);
    }

    /*
    @Override
    public List<? extends Mission> findAllByLocalozation(String localization){
        List<Mission> mission = new LinkedList<>();
        mission.addAll(this.missionRepository.findByDrone_Localization(localization));
        return mission;
    }*/


}
