package com.example.expo.Model.Entity;

import com.example.expo.Model.Entity.Stand;

public class StandScoreAvg {
    private Stand stand;
    private double posterAvg;
    private double presentationAvg;
    private double contentAvg;
    private double totalAvg;

    public StandScoreAvg(Stand stand, double posterAvg, double presentationAvg, double contentAvg, double totalAvg) {
        this.stand = stand;
        this.posterAvg = posterAvg;
        this.presentationAvg = presentationAvg;
        this.contentAvg = contentAvg;
        this.totalAvg = totalAvg;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public double getPosterAvg() {
        return posterAvg;
    }

    public void setPosterAvg(double posterAvg) {
        this.posterAvg = posterAvg;
    }

    public double getPresentationAvg() {
        return presentationAvg;
    }

    public void setPresentationAvg(double presentationAvg) {
        this.presentationAvg = presentationAvg;
    }

    public double getContentAvg() {
        return contentAvg;
    }

    public void setContentAvg(double contentAvg) {
        this.contentAvg = contentAvg;
    }

    public double getTotalAvg() {
        return totalAvg;
    }

    public void setTotalAvg(double totalAvg) {
        this.totalAvg = totalAvg;
    }
}

