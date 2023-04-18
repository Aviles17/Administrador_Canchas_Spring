package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.modelo.ReservasRepository;
import com.web.proyectocanchasg1.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservasControlador {

    ReservasService reservasRepository;

    @CrossOrigin
    @GetMapping(value = "/Reserva", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarReserva(@RequestParam Reservas reserva){
        reservasRepository.save(reserva);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Reserva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReservabyId(@PathVariable Long id) throws Exception{
        Reservas r = reservasRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(r.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Reserva/usuario_id_usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReservabyUserId(@PathVariable Long id){
        List<Reservas> r = reservasRepository.findbyUserId(id);
        String resResrv = r.toString();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(resResrv, responseHeaders, HttpStatus.OK );
    }

}
