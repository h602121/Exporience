package com.example.expo.Model.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exhibitor_stand", schema = "exporiencedb", catalog = "h602116")
public class ExhibitorStand {
    @Basic
    @Column(name = "exhibitor_id")
    private Integer exhibitorId;
    @Basic
    @Column(name = "stand_id")
    private String standId;
    @Basic
    @Id
    @Column(name = "exhibitor_stand_id")
    private Integer exhbitorStandId;

    public Integer getExhibitorId() {
        return exhibitorId;
    }

    public void setExhibitorId(Integer exhibitorId) {
        this.exhibitorId = exhibitorId;
    }

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }

    public Integer getExhbitorStandId() {
        return exhbitorStandId;
    }

    public void setExhbitorStandId(Integer exhbitorStandId) {
        this.exhbitorStandId = exhbitorStandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExhibitorStand that = (ExhibitorStand) o;
        return Objects.equals(exhibitorId, that.exhibitorId) && Objects.equals(standId, that.standId) && Objects.equals(exhbitorStandId, that.exhbitorStandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exhibitorId, standId, exhbitorStandId);
    }
}
