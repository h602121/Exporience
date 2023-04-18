package com.example.expo.Model.Entity;

import java.util.Random;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Random.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_votes", schema = "exporiencedb")
public class UserVotes {

    // existing fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Integer tableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qr_code", referencedColumnName = "qr_code", nullable = false)
    private Stand stand;

    // new fields
    @Column(name = "presentasjon")
    private Integer presentasjon;

    @Column(name = "panel")
    private Integer panel;

    @Column(name = "innhold")
    private Integer innhold;

    @Column(name = "interaksjon")
    private Integer interaksjon;

    @Column(name = "total")
    private Integer total;

    public UserVotes(){

    };

    public UserVotes(User user, Stand stand, Integer presentasjon, Integer panel, Integer innhold, Integer interaksjon, Integer total) {
        this.user = user;
        this.stand = stand;
        this.presentasjon = presentasjon;
        this.panel = panel;
        this.innhold = innhold;
        this.interaksjon = interaksjon;
        this.total = total;
    }

    // getters and setters for new fields
    public Integer getPresentasjon() {
        return presentasjon;
    }

    public void setPresentasjon(Integer presentasjon) {
        this.presentasjon = presentasjon;
    }

    public Integer getPanel() {
        return panel;
    }

    public void setPanel(Integer panel) {
        this.panel = panel;
    }

    public Integer getInnhold() {
        return innhold;
    }

    public void setInnhold(Integer innhold) {
        this.innhold = innhold;
    }

    public Integer getInteraksjon() {
        return interaksjon;
    }

    public void setInteraksjon(Integer interaksjon) {
        this.interaksjon = interaksjon;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    // existing getters and setters
    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }
}

