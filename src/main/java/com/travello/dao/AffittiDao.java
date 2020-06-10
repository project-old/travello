package com.travello.dao;

import java.math.BigInteger;
import java.util.List;

import com.travello.domain.Affitti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AffittiDao extends JpaRepository<Affitti,Long>{    
    @Query(value = "Select * from affitti where hotel_id = ?1", nativeQuery = true)
    List<Affitti> findByNomeOnly(BigInteger hotelId);
}