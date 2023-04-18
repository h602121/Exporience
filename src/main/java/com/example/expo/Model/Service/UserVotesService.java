package com.example.expo.Model.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Stemmer;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.UserVotes;
import com.example.expo.Model.Entity.VoteDTO;
import com.example.expo.Model.Repo.UserVotesRepo;

@Service
public class UserVotesService {

    @Autowired
    public UserService userService;

    @Autowired
    public UserVotesRepo userVotesRepo;
    @Autowired
    public StandService standService;
    @Autowired
    public StemmerService stemmerService;
    
    
    public UserVotes save(UserVotes userVotes) {
        
       
        return userVotesRepo.save(userVotes);
    }

    public void delete(UserVotes userVotes) {
        userVotesRepo.delete(userVotes);
    }

    public List<Stand> getStandsNotVotedOnByUser(Integer userId) {
       
        List<Stand> allStands = standService.getAllStands();
       
        //List<UserVotes> votedStands = userVotesRepo.findByUser(userService.findByMail(userId));
        //List<UserVotes> votedStands = userVotesRepo.findByUser(userId);

        List<UserVotes> allUserVotes = userVotesRepo.findAll();
        List<UserVotes> filteredUserVotes = allUserVotes.stream()
        .filter(uv -> uv.getUser().getId().equals(userId))
        .collect(Collectors.toList());

        List<Stand> stands = new ArrayList<>();
        if (!filteredUserVotes.isEmpty()) {
          
            for (UserVotes uv : filteredUserVotes) {
                Stand stand = standService.getStandbyStandId(uv.getStand().getQrCode());
                stands.add(stand);
            }
            
            allStands = allStands.stream()
                    .filter(stand -> !stands.contains(stand))
                    .collect(Collectors.toList());
        }
        
        return allStands;
    }

    public List<UserVotes> getUserVotesByUserId(Integer userId) {
        return userVotesRepo.findAll().stream()
                .filter(uv -> uv.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<UserVotes> findMyStands(Integer userId) {
       return userVotesRepo.findMyStands(userId);
    }

    public List<UserVotes> findAllUserVotes() {
        return userVotesRepo.findAll();
    }
    

    
    
    
    
    

    
}

    
    
    


    
    
    
