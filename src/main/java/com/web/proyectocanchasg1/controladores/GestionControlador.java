package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Gestion;
import com.web.proyectocanchasg1.modelo.GestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GestionControlador {

    @Autowired
    GestionRepository gestionRepository;


    @CrossOrigin
    @GetMapping(value = "/Gestion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarGestion(@RequestParam Gestion g){
        gestionRepository.save(g);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }


    @CrossOrigin
    @GetMapping(value = "/Gestion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGestorbyId(@PathVariable Long id) throws Exception{
        Gestion g = gestionRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Gestion/Reserva_id_reserva", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGestorbyReserva(@PathVariable Long id) throws Exception{
        Gestion g = gestionRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }


}
