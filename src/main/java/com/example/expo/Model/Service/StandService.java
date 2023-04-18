package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.ExhibitorStand;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Repo.StandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandService {

    @Autowired
    public StandRepo standRepo;

    public List<Stand> getAllStands(){

        return standRepo.findByActiveTrue();

    }
    public Integer addStand(Stand stand) {
        Stand savedStand = standRepo.save(stand);
        return savedStand.getQrCode();
    }
     public Stand getStandbyStandId(Integer standId){
        Stand stand=standRepo.getStandByQrCode(standId);
        if(stand==null){
            return null;
        }
        return stand;
      
    }
	public void setAllStandsInactive() {
        List<Stand> stands = standRepo.findByActiveTrue();
        for (Stand stand : stands) {
            stand.setIsActive(false);
            standRepo.save(stand);
        }
    }
    public boolean noActive() {
        List<Stand> activeStands = standRepo.findByActiveTrue();
        return activeStands.isEmpty();
    }
    public boolean isActive(List<Stand> stands) {
        for (Stand stand : stands) {
            if (stand.getIsActive()) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    

    



}
