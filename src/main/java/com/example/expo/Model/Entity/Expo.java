package com.example.expo.Model.Entity;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name="expo", schema = "ExporienceDB")
public class Expo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "expo_id")
    private int expoId;
    @Basic
    @Column(name = "expo_name")
    private String expoName;
    @Basic
    @Column(name = "expo_location")
    private String expoLocation;
    @Basic
    @Column(name = "expo_description")
    private String expoDescription;
    @Basic
    @Column(name = "expo_date")
    private Date expoDate;
    @Basic
    @Column(name = "expo_start")
    private Time expoStart;
    @Basic
    @Column(name = "expo_end")
    private Time expoEnd;

    public int getExpoId() {
        return expoId;
    }

    public void setExpoId(int expoId) {
        this.expoId = expoId;
    }

    public String getExpoName() {
        return expoName;
    }

    public void setExpoName(String expoName) {
        this.expoName = expoName;
    }

    public String getExpoLocation() {
        return expoLocation;
    }

    public void setExpoLocation(String expoLocation) {
        this.expoLocation = expoLocation;
    }

    public String getExpoDescription() {
        return expoDescription;
    }

    public void setExpoDescription(String expoDescription) {
        this.expoDescription = expoDescription;
    }

    public Date getExpoDate() {
        return expoDate;
    }

    public void setExpoDate(Date expoDate) {
        this.expoDate = expoDate;
    }

    public Time getExpoStart() {
        return expoStart;
    }

    public void setExpoStart(Time expoStart) {
        this.expoStart = expoStart;
    }

    public Time getExpoEnd() {
        return expoEnd;
    }

    public void setExpoEnd(Time expoEnd) {
        this.expoEnd = expoEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expo expo = (Expo) o;
        return expoId == expo.expoId && Objects.equals(expoName, expo.expoName) && Objects.equals(expoLocation, expo.expoLocation) && Objects.equals(expoDescription, expo.expoDescription) && Objects.equals(expoDate, expo.expoDate) && Objects.equals(expoStart, expo.expoStart) && Objects.equals(expoEnd, expo.expoEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expoId, expoName, expoLocation, expoDescription, expoDate, expoStart, expoEnd);
    }
}
