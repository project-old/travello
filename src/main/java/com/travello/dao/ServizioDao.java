package com.travello.dao;

import com.travello.domain.Servizio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServizioDao extends JpaRepository<Servizio, Long> {       
}