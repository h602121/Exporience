package com.example.expo.Model.Entity;



import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.expo.Model.Service.StandService;

import java.util.Objects;

@Entity
@Table(name = "stemmer", schema = "exporiencedb")
public class Stemmer {


    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @Column(name = "antall_stemmer")
    private Integer antallStemmer;

    @OneToOne
    @JoinColumn(name = "qr_code", referencedColumnName = "qr_code")
    private Stand stand;

    public Stemmer() {
    }

    public Stemmer(Integer presentasjon, Integer panel, Integer innhold, Integer interaksjon) {
        this.presentasjon = presentasjon;
        this.panel = panel;
        this.innhold = innhold;
        this.interaksjon = interaksjon;
        this.total = presentasjon + panel + innhold + interaksjon;
        this.antallStemmer = 0;
    }

    

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getAntallStemmer() {
        return antallStemmer;
    }

    public void setAntallStemmer(Integer antallStemmer) {
        this.antallStemmer = antallStemmer;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand=stand;
    }
  

    
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stemmer stemmer = (Stemmer) o;
        return Objects.equals(id, stemmer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getAverageTotal() {
        if (this.antallStemmer == 0) {
            return 0;
        } else {
            return Math.round(this.total / (this.antallStemmer * 4));
        }
    }

    public Integer getAveragePresentasjon() {
        if (this.antallStemmer == 0) {
            return 0;
        } else {
            return Math.round(this.presentasjon / this.antallStemmer);
        }
    }
    
    public Integer getAveragePanel() {
        if (this.antallStemmer == 0) {
            return 0;
        } else {
            return Math.round(this.panel / this.antallStemmer);
        }
    }
    
    public Integer getAverageInnhold() {
        if (this.antallStemmer == 0) {
            return 0;
        } else {
            return Math.round(this.innhold / this.antallStemmer);
        }
    }
    
    public Integer getAverageInteraksjon() {
        if (this.antallStemmer == 0) {
            return 0;
        } else {
            return Math.round(this.interaksjon / this.antallStemmer);
        }
    }


  
}
