package com.travello.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="camere")
public class Camera{
    @Id
    String tipologia;    
    String descrizione;


    public Camera() {
    }

    public Camera(String tipologia, String descrizione) {
        this.tipologia = tipologia;
        this.descrizione = descrizione;
    }

    public String getTipologia() {
        return this.tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Camera tipologia(String tipologia) {
        this.tipologia = tipologia;
        return this;
    }

    public Camera descrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

}