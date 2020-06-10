package com.travello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.travello.dao.ServizioDao;
import com.travello.domain.Servizio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/servizi", produces = "application/json")
public class ServizioController {

    @Autowired
    ServizioDao servizioDao;

    @GetMapping(value = "")
    public List<Servizio> getServizi() {        
        return this.servizioDao.findAll();
    }
}