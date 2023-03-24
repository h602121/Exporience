package com.example.expo.Model.Entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bachelor_project", schema = "exporiencedb", catalog = "h602116")
public class BachelorProject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "bachelor_name")
    private String bachelorName;
    @Basic
    @Column(name = "bachelor_description")
    private String bachelorDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBachelorName() {
        return bachelorName;
    }

    public void setBachelorName(String bachelorName) {
        this.bachelorName = bachelorName;
    }

    public String getBachelorDescription() {
        return bachelorDescription;
    }

    public void setBachelorDescription(String bachelorDescription) {
        this.bachelorDescription = bachelorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BachelorProject that = (BachelorProject) o;
        return id == that.id && Objects.equals(bachelorName, that.bachelorName) && Objects.equals(bachelorDescription, that.bachelorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bachelorName, bachelorDescription);
    }
}
