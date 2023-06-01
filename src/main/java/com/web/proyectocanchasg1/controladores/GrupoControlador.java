package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.*;
import com.web.proyectocanchasg1.security.keymanagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrupoControlador {

    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CanchasRepository canchasRepository;
    @Autowired
    ReservasRepository reservasRepository;

    @CrossOrigin
    @PostMapping(value = "/Grupo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarGrupos(@RequestParam String nombreE1,
                                                 @RequestParam String nombreE2,
                                                 @RequestParam String token,
                                                 @RequestParam String Cancha) {
        String username = keymanagment.decodeJWT(token);
        List<Usuario> U = usuarioRepository.findByName(username);
        List<Equipo> e1 = equipoRepository.findByNameE(nombreE1);
        List<Equipo> e2 = equipoRepository.findByNameE(nombreE2);
        List<Canchas> C = canchasRepository.findByName(Cancha);
        HttpHeaders responseHeaders = new HttpHeaders();
        if (U.get(0) != null && C.get(0) != null) {
            responseHeaders = new HttpHeaders();
            if (e1.get(0) != null && e2.get(0) != null) {
                List<Reservas> r = reservasRepository.findbyUserName(U.get(0).getNombreU());
                responseHeaders = new HttpHeaders();
                if (r.get(r.size()-1) != null) {
                    Grupo g = new Grupo(r.get(r.size() - 1), e1.get(0), e2.get(0));
                    grupoRepository.save(g);
                    responseHeaders = new HttpHeaders();
                    return new ResponseEntity<String>("{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK);
                } else {
                    return new ResponseEntity<String>("{\"respuesta\":\"fallo\":\"No existe reserva\"}", responseHeaders, HttpStatus.NO_CONTENT);
                }
            } else {
                return new ResponseEntity<String>("{\"respuesta\":\"fallo\":\"No existe algun equipo\"}", responseHeaders, HttpStatus.NO_CONTENT);

            }
        }
        else {
            return new ResponseEntity<String>("{\"respuesta\":\"fallo\":\"No existe usuario o cancha\"}", responseHeaders, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/Grupo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGrupobyId(@PathVariable Long id) throws Exception{
        Grupo g = grupoRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Grupo/Reserva_id_reserva/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGrupobyReserva(@PathVariable Long id,
                                                    @RequestParam String token) throws Exception{
        String username = keymanagment.decodeJWT(token);
        List<Usuario> U = usuarioRepository.findByName(username);
        if(!U.isEmpty()){
            Grupo g = grupoRepository.findById(id).get();
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>(g.toJSON().toString(), responseHeaders, HttpStatus.OK );
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"El usuario no tiene permisos sobre la reserva\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
