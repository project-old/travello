package com.travello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.travello.dao.LocalitaDao;
import com.travello.domain.Localita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/comuni", produces = "application/json")
public class ComuneController {

    @Autowired
    LocalitaDao localitaDao;

    @GetMapping(value = "")
    public List<Localita> getComuni(@RequestParam(required = false) String localita) {
        return this.localitaDao.findAll();
    }

    @GetMapping(value = "/names")
    public List<String> getComuniNomeOnly(){
        return this.localitaDao.findByNomeOnly();
    }    
}