package com.travello.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="attivita")
public class Attivita{
    @Id
    BigInteger hotelId;
    String nome;
    String indirizzo;
    String website;
    String email;
    String telefono;
    String tipologia;
    Integer stelle;
    String lon;
    String lat;
    String photoUrl;

    @ManyToOne
    @JoinColumn(name="nome_localita")
    @JsonIdentityReference
    Localita nomeLocalita;  
    
    public Attivita() {
    }

    public Attivita(BigInteger hotelId, String nome, String indirizzo, String website, String email, String telefono, String tipologia, Integer stelle, String lon, String lat, String photoUrl, Localita nomeLocalita) {
        this.hotelId = hotelId;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.website = website;
        this.email = email;
        this.telefono = telefono;
        this.tipologia = tipologia;
        this.stelle = stelle;
        this.lon = lon;
        this.lat = lat;
        this.photoUrl = photoUrl;
        this.nomeLocalita = nomeLocalita;
    }

    public BigInteger getHotelId() {
        return this.hotelId;
    }

    public void setHotelId(BigInteger hotelId) {
        this.hotelId = hotelId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipologia() {
        return this.tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getStelle() {
        return this.stelle;
    }

    public void setStelle(Integer stelle) {
        this.stelle = stelle;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Localita getNomeLocalita() {
        return this.nomeLocalita;
    }

    public void setNomeLocalita(Localita nomeLocalita) {
        this.nomeLocalita = nomeLocalita;
    }

    public Attivita hotelId(BigInteger hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public Attivita nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Attivita indirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
        return this;
    }

    public Attivita website(String website) {
        this.website = website;
        return this;
    }

    public Attivita email(String email) {
        this.email = email;
        return this;
    }

    public Attivita telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Attivita tipologia(String tipologia) {
        this.tipologia = tipologia;
        return this;
    }

    public Attivita stelle(Integer stelle) {
        this.stelle = stelle;
        return this;
    }

    public Attivita lon(String lon) {
        this.lon = lon;
        return this;
    }

    public Attivita lat(String lat) {
        this.lat = lat;
        return this;
    }

    public Attivita photoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Attivita nomeLocalita(Localita nomeLocalita) {
        this.nomeLocalita = nomeLocalita;
        return this;
    }

}