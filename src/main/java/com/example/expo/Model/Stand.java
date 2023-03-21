package com.example.expo.Model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Stand {
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "qr_code")
    private String qrCode;
    @Basic
    @Column(name = "exhibtor_id")
    private int exhibtorId;
    @Basic
    @Column(name = "bachelor_id")
    private Integer bachelorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getExhibtorId() {
        return exhibtorId;
    }

    public void setExhibtorId(int exhibtorId) {
        this.exhibtorId = exhibtorId;
    }

    public Integer getBachelorId() {
        return bachelorId;
    }

    public void setBachelorId(Integer bachelorId) {
        this.bachelorId = bachelorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stand stand = (Stand) o;
        return id == stand.id && exhibtorId == stand.exhibtorId && Objects.equals(qrCode, stand.qrCode) && Objects.equals(bachelorId, stand.bachelorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qrCode, exhibtorId, bachelorId);
    }
}
