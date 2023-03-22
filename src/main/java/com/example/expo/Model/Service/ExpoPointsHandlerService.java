package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.ExpoPointsHandler;
import com.example.expo.Model.Repo.ExpoPointHandlerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExpoPointsHandlerService {


    @Autowired
    public ExpoPointHandlerRepo voteHandlerRepo;


    public boolean addVoteHandler(int voteId, int userId, String standId, int expoId ){

        voteHandlerRepo.save(new ExpoPointsHandler(voteId,userId,standId,expoId));

        return true;

    }

}