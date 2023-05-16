package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservasControlador {

    @Autowired
    ReservasRepository reservasRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CanchasRepository canchasRepository;

    @CrossOrigin
    @PostMapping(value = "/Reserva", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarReserva(@RequestParam String fecha,
                                                  @RequestParam int horai,
                                                  @RequestParam int horaf,
                                                  @RequestParam String usuario,
                                                  @RequestParam String cancha){

        List<Canchas> c = canchasRepository.findByName(cancha);
        List<Usuario> u = usuarioRepository.findByName(usuario);
        HttpHeaders responseHeaders = new HttpHeaders();
        if(u.get(0) != null){
            if(c.get(0) != null){
                Reservas reserva = new Reservas(fecha,horai,horaf,u.get(0),c.get(0));
                reservasRepository.save(reserva);
                return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
            }
            else{
                return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"no existe cancha\"}", responseHeaders, HttpStatus.NO_CONTENT);

            }
        }
        else{
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"no existe usuario\"}", responseHeaders, HttpStatus.NO_CONTENT);
        }
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
