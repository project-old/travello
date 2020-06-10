package com.travello.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localita")

public class Localita{
    @Id                
    String nomeLocalita;
    String cap;
    String altitudine;


    public Localita() {
    }

    public Localita(String nomeLocalita, String cap, String altitudine) {
        this.nomeLocalita = nomeLocalita;
        this.cap = cap;
        this.altitudine = altitudine;
    }

    public String getNomeLocalita() {
        return this.nomeLocalita;
    }

    public void setNomeLocalita(String nomeLocalita) {
        this.nomeLocalita = nomeLocalita;
    }

    public String getCap() {
        return this.cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getAltitudine() {
        return this.altitudine;
    }

    public void setAltitudine(String altitudine) {
        this.altitudine = altitudine;
    }

    public Localita nomeLocalita(String nomeLocalita) {
        this.nomeLocalita = nomeLocalita;
        return this;
    }

    public Localita cap(String cap) {
        this.cap = cap;
        return this;
    }

    public Localita altitudine(String altitudine) {
        this.altitudine = altitudine;
        return this;
    }

}