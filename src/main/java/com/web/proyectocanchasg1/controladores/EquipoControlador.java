package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.modelo.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipoControlador {

    @Autowired
    EquipoRepository equipoRepository;


    @CrossOrigin
    @GetMapping(value = "/Equipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  insertarEquipo(@RequestParam Equipo e) throws Exception{
        equipoRepository.save(e);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }
    @CrossOrigin
    @GetMapping(value = "/Equipo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEquipobyId(@PathVariable Long id) throws Exception{
        Equipo e = equipoRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(e.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }
    @CrossOrigin
    @GetMapping(value = "/Equipo/nombre_equipo/{nombre_equipo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEquipobyName(@PathVariable String name) throws Exception{
        List<Equipo> e = equipoRepository.findByNameE(name);
        String resEquipo = e.toString();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(resEquipo, responseHeaders, HttpStatus.OK );
    }
}
