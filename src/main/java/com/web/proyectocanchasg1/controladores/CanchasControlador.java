package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CanchasControlador {

    @Autowired
    CanchasRepository canchasRepository;

    @CrossOrigin
    @GetMapping(value = "/insertar-cancha", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> insertar() throws Exception{
        Canchas cancha = new Canchas("Cancha1",10,21,"17/07/2022");
        canchasRepository.save(cancha);


        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }



}
