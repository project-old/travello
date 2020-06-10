package com.travello.dao;

import java.math.BigInteger;
import java.util.List;

import com.travello.domain.ServiziHotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ServizioHotelDao extends JpaRepository<ServiziHotel,Long>{    
    @Query(value = "Select * from servizi_hotel where hotel_id = ?1", nativeQuery = true)
    List<ServiziHotel> findByNomeOnly(BigInteger hotelId);
}