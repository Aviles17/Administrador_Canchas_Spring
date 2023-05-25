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
    @Autowired
    GrupoRepository grupoRepository;

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
                return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"no existe cancha\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
        else{
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"no existe usuario\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/Reserva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReservabyId(@PathVariable Long id) throws Exception{
        if(reservasRepository.findById(id).isPresent()){
            Reservas r = reservasRepository.findById(id).get();
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>(r.toJSON().toString(), responseHeaders, HttpStatus.OK );
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"no existe usuario\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/Reserva/usuario_id_usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReservabyUserId(@PathVariable Long id){
        List<Reservas> r = reservasRepository.findbyUserId(id);
        String resResrv = r.toString();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(resResrv, responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @DeleteMapping(value = "/Reserva/removeID/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteReservasbyID(@PathVariable Long id ){
        List<Grupo> gruposReserva = grupoRepository.findbyIdReserva(id);
        if(gruposReserva.size() == 0){
            if(reservasRepository.findById(id).isPresent()){
                Reservas r = reservasRepository.findById(id).get();
                reservasRepository.delete(r);
                HttpHeaders responseHeaders = new HttpHeaders();
                return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
            }
            else{
                HttpHeaders responseHeaders = new HttpHeaders();
                return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"La reserva no existe\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR );
            }
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"Existen grupos relacionados a la reserva\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR );

        }
    }

}
