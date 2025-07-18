package com.coterena.oficinatecnica.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/check_horas")
public class CheckControlHorarioController {

    @GetMapping
    public Map<String,String> about(){
        return Collections.singletonMap("msj", "check control horario");
    }

}