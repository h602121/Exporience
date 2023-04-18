package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.ExpoPointsHandler;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Repo.ExpoPointHandlerRepo;
import com.example.expo.StandScoreAvg;
import com.example.expo.VoteListByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public List<StandScoreAvg> getAverageScoreAllStands(){

        List<Stand> stands = standService.getAllStands();

        List<StandScoreAvg> standScoreAvgList = new ArrayList<StandScoreAvg>();

        for (Stand stand: stands) {

            int standId = stand.getQrCode();
            List<Integer> votesId = getAllVotesByStandId(standId);
            List<Vote> allVotes = voteService.getAllVotesById(votesId);

            double avgPoster = 0;
            double avgContent = 0;
            double avgPresentation = 0;
            double average = 0;

            for(Vote vote : allVotes){
                avgContent += vote.getContentRating();
                avgPoster += vote.getPosterRating();
                avgPresentation += vote.getPresentationRating();

                average += avgContent;
                average += avgPoster;
                average += avgPresentation;

                average /= 3;
            }

            avgContent = avgContent/allVotes.size();

            avgPresentation = avgPresentation/ allVotes.size();

            avgPoster = avgPoster/ allVotes.size();

            average = average/allVotes.size();

            avgPresentation = Math.floor(avgPresentation * 100) / 100;

            avgContent = Math.floor(avgContent * 100) / 100;

            avgPoster = Math.floor(avgPoster * 100) / 100;

            average = Math.floor(average * 100) / 100;


            standScoreAvgList.add(new StandScoreAvg(stand,avgPoster,avgPresentation,avgContent,average));

        }

            sortStandScoreAvgList(standScoreAvgList);

        return standScoreAvgList;
    }

    private List<StandScoreAvg> sortStandScoreAvgList(List<StandScoreAvg> standScoreAvgList){

        for (StandScoreAvg standscoreavg: standScoreAvgList) {
            if(Double.isFinite(standscoreavg.getTotalAvg())){

            } else{
                standscoreavg.setContentAvg(0.0);
                standscoreavg.setPosterAvg(0.0);
                standscoreavg.setPresentationAvg(0.0);
                standscoreavg.setTotalAvg(0.0);
            }
        }


        standScoreAvgList.sort(Comparator.comparing(StandScoreAvg::getTotalAvg).reversed());
        return standScoreAvgList;
    }




}