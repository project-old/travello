package com.travello.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Embeddable
class ServiziHotelKey implements Serializable {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    BigInteger hotel_id;
 
    String servizio_id;
 
    // standard constructors, getters, and setters
    // hashcode and equals implementation
}

@Entity
@Table(name="servizi_hotel")
public class ServiziHotel{
    @EmbeddedId 
    ServiziHotelKey id;
    
    @ManyToOne
    @MapsId("servizio_id")
    @JoinColumn(name = "servizio_id")
    Servizio servizio;

    public ServiziHotel() {
    }

    public ServiziHotel(ServiziHotelKey id, Servizio servizio) {
        this.id = id;
        this.servizio = servizio;
    }

    public ServiziHotelKey getId() {
        return this.id;
    }

    public void setId(ServiziHotelKey id) {
        this.id = id;
    }

    public Servizio getServizio() {
        return this.servizio;
    }

    public void setServizio(Servizio servizio) {
        this.servizio = servizio;
    }

    public ServiziHotel id(ServiziHotelKey id) {
        this.id = id;
        return this;
    }

    public ServiziHotel servizio(Servizio servizio) {
        this.servizio = servizio;
        return this;
    }

}