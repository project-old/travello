package com.travello.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servizi")
public class Servizio{
    @Id
    String servizio_id;
    String descrizione;


    public Servizio() {
    }

    public Servizio(String servizio_id, String descrizione) {
        this.servizio_id = servizio_id;
        this.descrizione = descrizione;
    }

    public String getServizio_id() {
        return this.servizio_id;
    }

    public void setServizio_id(String servizio_id) {
        this.servizio_id = servizio_id;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Servizio servizio_id(String servizio_id) {
        this.servizio_id = servizio_id;
        return this;
    }

    public Servizio descrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

}