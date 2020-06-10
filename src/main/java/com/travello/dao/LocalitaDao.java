package com.travello.dao;

import java.util.List;

import com.travello.domain.Localita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocalitaDao extends JpaRepository<Localita, Long> {
    Localita findByNomeLocalita(String nomeLocalita);

    @Query(value = "Select nome_localita from localita", nativeQuery = true)
    List<String> findByNomeOnly();

}