package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.modelo.ReservasRepository;
import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UsuarioControlador {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ReservasRepository reservasRepository;

    @CrossOrigin
    @PostMapping(value = "/Usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarUsuario(@RequestParam String Usuario,
                                                  @RequestParam String Clave) throws Exception{
        Usuario u = new Usuario(Usuario,Clave);
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
    @GetMapping(value = "/Usuario/name_usuario/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUsuariobyName(@PathVariable String name) throws Exception{
        List<Usuario> u = usuarioRepository.findByName(name);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(u.toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @DeleteMapping(value = "/Usuario/removeAll/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> DeletebyName(@PathVariable String name) throws Exception{
        List<Reservas> reservasUsuario = reservasRepository.findbyUserName(name);
        if(reservasUsuario.size() == 0){
            List<Usuario> u =  usuarioRepository.findByName(name);
            usuarioRepository.deleteAll(u);
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"Existen reservas con el usuario\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR );

        }
    }

    @CrossOrigin
    @DeleteMapping(value = "/Usuario/removeID/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> DeletebyId(@PathVariable Long id) throws Exception{
        List<Reservas> reservasUsuario = reservasRepository.findbyUserId(id);
        if(reservasUsuario.size() == 0){
            Usuario u =  usuarioRepository.findById(id).get();
            usuarioRepository.delete(u);
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            return  new ResponseEntity<String>( "{\"respuesta\":\"fallo\":\"Existen reservas con el usuario\"}", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR );

        }
    }

}
