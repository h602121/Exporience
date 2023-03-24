package com.example.expo.Model.Entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "expo_points_handler", schema = "exporiencedb", catalog = "h602116")
public class ExpoPointsHandler {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "vote_id")
    private Integer voteId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "stand_id")
    private String standId;
    @Basic
    @Column(name = "expo_id")
    private Integer expoId;

    public ExpoPointsHandler() {
    }

    public ExpoPointsHandler(Integer voteId, Integer userId, String standId, Integer expoId) {
        this.voteId = voteId;
        this.userId = userId;
        this.standId = standId;
        this.expoId = expoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }

    public Integer getExpoId() {
        return expoId;
    }

    public void setExpoId(Integer expoId) {
        this.expoId = expoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpoPointsHandler that = (ExpoPointsHandler) o;
        return id == that.id && Objects.equals(voteId, that.voteId) && Objects.equals(userId, that.userId) && Objects.equals(standId, that.standId) && Objects.equals(expoId, that.expoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voteId, userId, standId, expoId);
    }
}
