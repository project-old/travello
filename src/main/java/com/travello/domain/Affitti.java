package com.travello.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
class AffittoKey implements Serializable {    

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    BigInteger hotel_id;
    String tipologia;
}

@Entity
@Table(name="affitti")
public class Affitti{
    @EmbeddedId
    AffittoKey id;

    @ManyToOne
    @JoinColumn(name = "tipologia", insertable = false, updatable = false)
    Camera camera;

    String prezzo;


    public Affitti() {
    }

    public Affitti(AffittoKey id, Camera camera, String prezzo) {
        this.id = id;
        this.camera = camera;
        this.prezzo = prezzo;
    }

    public AffittoKey getId() {
        return this.id;
    }

    public void setId(AffittoKey id) {
        this.id = id;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public Affitti id(AffittoKey id) {
        this.id = id;
        return this;
    }

    public Affitti camera(Camera camera) {
        this.camera = camera;
        return this;
    }

    public Affitti prezzo(String prezzo) {
        this.prezzo = prezzo;
        return this;
    }

}