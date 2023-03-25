package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Repo.StandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandService {

    @Autowired
    public StandRepo standRepo;

    public List<Stand> getAllStands(){

        return standRepo.findAll();

    }
    public boolean addStand(String name, String description){

        standRepo.save(new Stand(name, description));

        return true;

    }


}
