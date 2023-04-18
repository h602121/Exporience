package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.ExhibitorStand;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Repo.ExhibitorStandRepo;
import com.example.expo.Model.Repo.StandRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitorStandService {

    @Autowired
    public ExhibitorStandRepo exhibitorStandRepo;

    @Autowired
    public StandService standService;

    @Autowired
    public StandRepo standRepo;

    public List<Stand> findStandByUserId(Integer userId) {
        List<ExhibitorStand> exhibitorStands = exhibitorStandRepo.findByExhibitorId(userId);
    List<Stand> activeStands = new ArrayList<>();
    for (ExhibitorStand exhibitorStand : exhibitorStands) {
        Stand stand = standService.getStandbyStandId(exhibitorStand.getStandId());
        if (stand != null && stand.getIsActive()) {
            activeStands.add(stand);
        }
    }
    return activeStands;
    }
    
    
    public boolean addExhbitorStand( Integer exhibitorId,Integer standId){
        exhibitorStandRepo.save(new ExhibitorStand(exhibitorId,standId));
        return true;
    }


    public List<Stand> findFullStandByUserId(Integer userId) {
        List<ExhibitorStand> exhibitorStands = exhibitorStandRepo.findByExhibitorId(userId);
        List<Stand> stands = new ArrayList<>();
        for (ExhibitorStand exhibitorStand : exhibitorStands) {
            Stand stand = standRepo.getStandByQrCode(exhibitorStand.getStandId());
            if (stand != null) {
                stands.add(stand);
            }
        }
        return stands;
    }


    public Integer findStandIdByUserId(Integer id) {
        return null;
    }


    public List<Stand> findAllStands() {
        List<Stand> allStands = standRepo.findAll();
        List<Stand> stands = new ArrayList<>();
        for (Stand stand : allStands) {
            stands.add(stand);
        }
        return stands;
    }
    
    
    
    
    
    
    
}
