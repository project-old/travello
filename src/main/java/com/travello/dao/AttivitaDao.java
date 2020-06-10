package com.travello.dao;

import java.math.BigInteger;
import java.util.List;

import com.travello.domain.Attivita;
import com.travello.domain.Localita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttivitaDao extends JpaRepository<Attivita,Long>{    
    List<Attivita> findByNomeLocalita(Localita nomeLocalita);
    Attivita findByHotelId(BigInteger hotelId);
}