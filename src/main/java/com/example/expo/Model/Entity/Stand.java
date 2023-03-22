package com.example.expo.Model.Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "stand",schema = "exporiencedb")
public class Stand {
    @Basic
    @Id
    @Column(name = "qr_code")
    private String qrCode;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name="stand_description")
    private String stand_description;

    public Stand() {
    }

    public Stand(String qrCode, String name, String stand_description) {
        this.qrCode = qrCode;
        this.name = name;
        this.stand_description = stand_description;
    }

    public String getStand_description() {
        return stand_description;
    }

    public void setStand_description(String stand_description) {
        this.stand_description = stand_description;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stand stand = (Stand) o;
        return Objects.equals(qrCode, stand.qrCode) && Objects.equals(name, stand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrCode, name);
    }
}
