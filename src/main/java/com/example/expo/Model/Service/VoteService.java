package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Repo.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    public VoteRepo voteRepo;

    public int addVote(int posterRating, int contentRating, int presentationRating){


       return voteRepo.save(new Vote(posterRating,contentRating,presentationRating)).getId();
    }
    public int getAverageScore(int id){

        return -1;

    }








}
