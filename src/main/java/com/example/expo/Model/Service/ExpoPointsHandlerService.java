package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.ExpoPointsHandler;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Repo.ExpoPointHandlerRepo;
import com.example.expo.VoteListByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpoPointsHandlerService {


    @Autowired
    public ExpoPointHandlerRepo voteHandlerRepo;

    @Autowired
    public VoteService voteService;

    @Autowired
    public StandService standService;


    public boolean addVoteHandler(int voteId, int userId, int standId, int expoId) {

        voteHandlerRepo.save(new ExpoPointsHandler(voteId, userId, standId, expoId));

        return true;

    }

    public boolean checkIfUseridAndStandIdHasAlreadyVoted(Integer userId, Integer standId) {
        return voteHandlerRepo.getExpoPointsHandlerByUserIdAndStandId(userId, standId) == null;
    }


    public List<VoteListByUser> getVotesByUserId(Integer userId) {
        System.out.println("user id:" + userId);

        List<ExpoPointsHandler> list = voteHandlerRepo.getAllByUserId(userId);

        List<Vote> votes = voteService.getAllVotesById(list.stream().map(a -> a.getVoteId()).collect(Collectors.toList()));


        List<Stand> stands = standService.getAllStands();


        List<VoteListByUser> newStands = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < stands.size(); j++) {
                if (list.get(i).getStandId().equals(stands.get(j).getQrCode())) {
                    newStands.add(new VoteListByUser(votes.get(i), stands.get(j)));
                }
            }
        }

        return newStands;
    }

    public List<Integer> getAllVotesByStandId(Integer standId) {
        List<ExpoPointsHandler> allVotes = voteHandlerRepo.getAllByStandId(standId);
        return allVotes.stream().map(a -> a.getVoteId()).collect(Collectors.toList());
    }

}