package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Grupo;
import com.web.proyectocanchasg1.modelo.GrupoRepository;
import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GrupoControlador {

    GrupoService grupoRepository;

    @CrossOrigin
    @GetMapping(value = "/Grupo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarGrupos(@RequestParam Grupo g){
        grupoRepository.save(g);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Grupo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGrupobyId(@PathVariable Long id) throws Exception{
        Grupo g = grupoRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Grupo/Reserva_id_reserva/{Reserva_id_reserva}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGrupobyReserva(@PathVariable Long id) throws Exception{
        Grupo g = grupoRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }
}
