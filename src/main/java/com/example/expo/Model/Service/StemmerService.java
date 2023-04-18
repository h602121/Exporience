package com.example.expo.Model.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Stemmer;
import com.example.expo.Model.Entity.Winner;
import com.example.expo.Model.Repo.StemmerRepo;

@Service
public class StemmerService {
    
    @Autowired
    public StemmerRepo stemmerRepo;

    @Autowired
    public WinnerTimeService winnerService;


    public Stemmer findByStandId(Stand standId) {
        Stemmer stemmer=stemmerRepo.findByQrCode(standId.getQrCode());
        if(stemmer==null){
            return null;
        }
        return stemmer;

    }
    public Stemmer save(Stemmer stemmer){
        stemmerRepo.save(stemmer);
        return stemmer;
    }

    public void updateStemmer(Integer presentasjon, Integer panel, Integer innhold, Integer interaksjon, Stemmer stemmer) {
        stemmer.setPresentasjon(stemmer.getPresentasjon() + presentasjon);
        stemmer.setPanel(stemmer.getPanel() + panel);
        stemmer.setInnhold(stemmer.getInnhold() + innhold);
        stemmer.setInteraksjon(stemmer.getInteraksjon() + interaksjon);
        stemmer.setTotal(stemmer.getPresentasjon() + stemmer.getPanel() + stemmer.getInnhold() + stemmer.getInteraksjon());
        stemmer.setAntallStemmer(stemmer.getAntallStemmer() + 1);
        stemmerRepo.save(stemmer);
    }
    public Stand declareWinner() {
        List<Stemmer> stemmerList = stemmerRepo.findByActiveStand();
        if (stemmerList.isEmpty()) {
            return null;
        }
        Stemmer winnerStemmer = null;
        for (Stemmer stemmer : stemmerList) {
            if (stemmer.getStand().getIsActive()) {
                winnerStemmer = (winnerStemmer == null || stemmer.getTotal() > winnerStemmer.getTotal()) ? stemmer : winnerStemmer;
            }
        }
        if (winnerStemmer == null) {
            return null;
        }
        Stand winnerStand = winnerStemmer.getStand();
    
        // Find the active winner entity
        Winner activeWinner = winnerService.findCurrentWinnerTime();
        if (activeWinner != null) {
            // Update the winner entity with the winning stand's QR code
            activeWinner.setStand(winnerStand);
            activeWinner.setActive(false);
            winnerService.saveWinnerTime(activeWinner);
        }
    
        return winnerStand;
    }
    
    
    
    
}
