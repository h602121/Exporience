package com.example.expo.Model.Service;

import com.example.expo.Model.Repo.ExhibitorStandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitorStandService {

    @Autowired
    public ExhibitorStandRepo exhibitorStandRepo;

    public Integer findStandByUserId(Integer userId){
        return exhibitorStandRepo.findByExhibitorId(userId).getStandId();
    }
}
