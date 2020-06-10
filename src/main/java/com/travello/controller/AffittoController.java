package com.travello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import com.travello.dao.AffittiDao;
import com.travello.domain.Affitti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/affitto", produces = "application/json")
public class AffittoController {

    @Autowired
    AffittiDao affittoDao;

    @GetMapping(value = "")
    public List<Affitti> getAffitti(@RequestParam(required = false) BigInteger id) {        
        return this.affittoDao.findByNomeOnly(id);
    }
}