package com.example.expo.Model.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "winner", schema = "ExporienceDB")
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "winner_date")
    private LocalDate winnerDate;

    @Column(name = "winner_time")
    private LocalTime winnerTime;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    @Column(name = "current", columnDefinition = "boolean default true")
    private boolean current;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "qr_code", referencedColumnName = "qr_code")
    private Stand stand;

    // Constructors
    public Winner() {
        this.active = true;
        this.current = true;
    }

    public Winner(LocalDate winnerDate, LocalTime winnerTime) {
        this.winnerDate = winnerDate;
        this.winnerTime = winnerTime;
        this.active = true;
        this.current = true;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWinnerDate() {
        return winnerDate;
    }

    public void setWinnerDate(LocalDate winnerDate) {
        this.winnerDate = winnerDate;
    }

    public LocalTime getWinnerTime() {
        return winnerTime;
    }

    public void setWinnerTime(LocalTime winnerTime) {
        this.winnerTime = winnerTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }
}
