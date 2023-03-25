package com.example.expo.Model.Entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name="vote", schema = "ExporienceDB")
public class Vote {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "poster_rating")
    private Integer posterRating;
    @Basic
    @Column(name = "content_rating")
    private Integer contentRating;
    @Basic
    @Column(name = "presentation_rating")
    private Integer presentationRating;

    public Vote() {
    }

    public Vote(Integer posterRating, Integer contentRating, Integer presentationRating) {
        this.posterRating = posterRating;
        this.contentRating = contentRating;
        this.presentationRating = presentationRating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPosterRating() {
        return posterRating;
    }

    public void setPosterRating(Integer posterRating) {
        this.posterRating = posterRating;
    }

    public Integer getContentRating() {
        return contentRating;
    }

    public void setContentRating(Integer contentRating) {
        this.contentRating = contentRating;
    }

    public Integer getPresentationRating() {
        return presentationRating;
    }

    public void setPresentationRating(Integer presentationRating) {
        this.presentationRating = presentationRating;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id && Objects.equals(posterRating, vote.posterRating) && Objects.equals(contentRating, vote.contentRating) && Objects.equals(presentationRating, vote.presentationRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, posterRating, contentRating, presentationRating);
    }
}
