package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.Expo;
import com.example.expo.Model.Repo.ExpoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpoService {

    @Autowired
    public ExpoRepo expoRepo;

    public Expo findExpoByName(String name){
        return expoRepo.findByExpoName(name);
    }
}
