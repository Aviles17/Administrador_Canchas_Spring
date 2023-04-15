package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    UsuarioRepository usuarioRepository;

    @CrossOrigin
    @GetMapping(value = "/Usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarUsuario(@RequestParam Usuario u) throws Exception{
        usuarioRepository.save(u);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUsuarionyId(@PathVariable Long id) throws Exception{
        Usuario u = usuarioRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(u.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }
    @CrossOrigin
    @GetMapping(value = "/Usuario/{name_usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUsuariobyName(@PathVariable String name) throws Exception{
        List<Usuario> u = usuarioRepository.findByName(name);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(u.toString(), responseHeaders, HttpStatus.OK );
    }
}
