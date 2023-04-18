package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Repo.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    public VoteRepo voteRepo;

    public int addVote(Integer posterRating, Integer contentRating, Integer presentationRating) {


        return voteRepo.save(new Vote(posterRating, contentRating, presentationRating)).getId();
    }

    public List<Vote> getAllVotes() {
        return voteRepo.findAll();
    }

    public List<Vote> getAllVotesById(List<Integer> votesId) {
        return voteRepo.findAllByIdIn(votesId);
    }


}
