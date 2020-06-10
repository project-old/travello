package com.travello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import com.travello.dao.ServizioHotelDao;
import com.travello.domain.ServiziHotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/serviziHotel", produces = "application/json")
public class ServizioHotelController {

    @Autowired
    ServizioHotelDao servizioHotelDao;

    @GetMapping(value = "")
    public List<ServiziHotel> getAffitti(@RequestParam(required = false) BigInteger id) {        
        return this.servizioHotelDao.findByNomeOnly(id);
    }
}