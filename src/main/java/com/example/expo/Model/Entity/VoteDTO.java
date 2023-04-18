package com.example.expo.Model.Entity;

public class VoteDTO {
    private Stand stand;
    private Integer presentasjon;
    private Integer panel;
    private Integer innhold;
    private Integer interaksjon;
    private Integer total;

    public VoteDTO(Stand stand, Integer presentasjon, Integer panel, Integer innhold, Integer interaksjon, Integer total) {
        this.stand = stand;
        this.presentasjon = presentasjon;
        this.panel = panel;
        this.innhold = innhold;
        this.interaksjon = interaksjon;
        this.total = total;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
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
}
