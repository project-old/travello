package com.travello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import com.travello.dao.AttivitaDao;
import com.travello.dao.LocalitaDao;
import com.travello.domain.Attivita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/attivita", produces = "application/json")
public class AttivitaController {

    @Autowired
    LocalitaDao localitaDao;
    @Autowired
    AttivitaDao attivitaDao;

    @GetMapping(value = "")
    public List<Attivita> getComuni(@RequestParam(required = false) String localita) {
        if (localita == null) {
            return this.attivitaDao.findAll();
        } else {
            return this.attivitaDao.findByNomeLocalita(this.localitaDao.findByNomeLocalita(localita));
        }
    }

    @GetMapping(value = "/detail")
    public Attivita getAttivitaDetail(BigInteger id) {
        {
            return this.attivitaDao.findByHotelId(id);
        }
    }

    @GetMapping(value = "/all")
    public List<Attivita> getAttivitta() {
        return this.attivitaDao.findAll();
    }

}