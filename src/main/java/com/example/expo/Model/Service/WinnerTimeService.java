package com.example.expo.Model.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Entity.Winner;
import com.example.expo.Model.Repo.VoteRepo;
import com.example.expo.Model.Repo.WinnerTimeRepo;
import com.example.expo.VoteListByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WinnerTimeService {
    
    @Autowired
    public WinnerTimeRepo winnerTimeRepo;

    public void saveWinnerTime(Winner winnerTime) {
        List<Winner> activeWinnerTimes = winnerTimeRepo.findByActiveTrue();
        if (!activeWinnerTimes.isEmpty()) {
            Winner activeWinnerTime = activeWinnerTimes.get(0);
            activeWinnerTime.setWinnerDate(winnerTime.getWinnerDate());
            activeWinnerTime.setWinnerTime(winnerTime.getWinnerTime());
            winnerTimeRepo.save(activeWinnerTime);
        } else {
            winnerTimeRepo.save(winnerTime);
        }
    }

    public Winner setNotCurrent(){
        List<Winner> winners = winnerTimeRepo.findByCurrentTrue();
        Winner currentWinner = null;
        for(Winner winner: winners) {
            if(winner.isCurrent()) {
                currentWinner = winner;
                break;
            }
        }
        if (currentWinner != null) {
            currentWinner.setCurrent(false);
            winnerTimeRepo.save(currentWinner);
        }
        return currentWinner;
    }
    
    public Winner findActiveWinnerTime() {
        List<Winner> activeWinnerTimes = winnerTimeRepo.findByActiveTrue();
        if (activeWinnerTimes.isEmpty()) {
            return null;
        } else {
            Winner activeWinnerTime = activeWinnerTimes.get(0);
            if (activeWinnerTime.getWinnerDate().atTime(activeWinnerTime.getWinnerTime()).isBefore(LocalDateTime.now())) {
                activeWinnerTime.setActive(false);
                return winnerTimeRepo.save(activeWinnerTime);
            } else {
                return activeWinnerTime;
            }
        }
    }

    public List<Stand> getAllWinner() {
        List<Winner> winners = winnerTimeRepo.findAll();
        List<Stand> stands = new ArrayList<>();
        for (Winner winner : winners) {
            Stand stand = winner.getStand();
            if (stand != null && stand.getQrCode() != null) {
                stands.add(stand);
            }
        }
        return stands;
    }

    public Winner findCurrentWinnerTime() {
        List<Winner> activeWinnerTimes = winnerTimeRepo.findByCurrentTrue();
        if (activeWinnerTimes.isEmpty()) {
            return null;
        } else {
            Winner activeWinnerTime = activeWinnerTimes.get(0);
            if (activeWinnerTime.getWinnerDate().atTime(activeWinnerTime.getWinnerTime()).isBefore(LocalDateTime.now())) {
                activeWinnerTime.setActive(false);
                return winnerTimeRepo.save(activeWinnerTime);
            } else {
                return activeWinnerTime;
            }
        }
    }

    public void setAllInactive() {
        List<Winner> winners = winnerTimeRepo.findAll();
        for (Winner winner : winners) {
            winner.setCurrent(false);
            winnerTimeRepo.save(winner);
        }
    }
    
    
    
    
}
