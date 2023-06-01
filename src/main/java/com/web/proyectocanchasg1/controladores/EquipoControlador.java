package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.modelo.EquipoRepository;
import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import com.web.proyectocanchasg1.security.keymanagment;
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
    @Autowired
    UsuarioRepository usuarioRepository;


    @CrossOrigin
    @PostMapping(value = "/Equipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  insertarEquipo(@RequestParam String nombre,
                                                  @RequestParam String token) throws Exception{
        String username = keymanagment.decodeJWT(token);
        List<Usuario> u = usuarioRepository.findByName(username);
        if(!u.isEmpty()){
            Equipo e = new Equipo(nombre);
            equipoRepository.save(e);
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"El usuario no tiene permisos sobre la aplicacion\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);

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
    public ResponseEntity<String> getEquipobyName(@PathVariable String nombre_equipo,
                                                  @RequestParam String token) throws Exception{
        String username = keymanagment.decodeJWT(token);
        List<Usuario> u = usuarioRepository.findByName(username);
        if(!u.isEmpty()){
            List<Equipo> e = equipoRepository.findByNameE(nombre_equipo);
            String resEquipo = e.toString();
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>(resEquipo, responseHeaders, HttpStatus.OK );
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"El usuario no tiene permisos sobre la aplicacion\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
