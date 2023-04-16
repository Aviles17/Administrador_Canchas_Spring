package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CanchasControlador {

    @Autowired
    CanchasRepository canchasRepository;

    @CrossOrigin
    @GetMapping(value = "/Canchas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarCancha(@RequestParam Canchas cancha) throws Exception{
        canchasRepository.save(cancha);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Canchas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> getCanchas(  @PathVariable Long id  ) throws Exception{
        Canchas cancha = canchasRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(cancha.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Canchas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarMultiplesCanchas(@RequestParam ArrayList<Canchas> canchas) throws Exception{
        ArrayList<String> numRes = new ArrayList<>();
        for(Canchas c: canchas){
            ResponseEntity<String> res = insertarCancha(c);
            numRes.add(res.toString());
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        if(numRes.size() == canchas.size()){
            return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK);
        }
        return  new ResponseEntity<String>( "{\"respuesta\":\"error\"}", responseHeaders, HttpStatus.EXPECTATION_FAILED);
    }
    @CrossOrigin
    @GetMapping(value = "/Canchas/nombre_canchas/{nombre_canchas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFromNameCanchas(@PathVariable String nombre_canchas) throws Exception{
        List<Canchas> c = canchasRepository.findByName(nombre_canchas);
        String resCanchas = c.toString();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(resCanchas, responseHeaders, HttpStatus.OK );
    }
}
