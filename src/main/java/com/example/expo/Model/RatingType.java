package com.example.expo.Model;

public enum RatingType {

    POSTER_RATING(1),

    CONTENT_RATING(2),

    PRESENTATION_RATING(3);

    private final int i;

    RatingType(int i){
        this.i = i;
    }

    public int getRatingType(){
        return this.i;
    }
}
