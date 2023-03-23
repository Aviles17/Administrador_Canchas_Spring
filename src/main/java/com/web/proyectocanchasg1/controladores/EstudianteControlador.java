/*
package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.modelo.EquipoRepository;
import com.web.proyectocanchasg1.modelo.Estudiante;
import com.web.proyectocanchasg1.modelo.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudianteControlador {

    @Autowired
    EquipoRepository equipoRepository;


    @CrossOrigin
    @GetMapping(value = "/equipo/{idEquipo}/estudiantes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEstudiante(@PathVariable Long idEquipo  ) throws Exception{
        Equipo equipo = equipoRepository.findById((long) idEquipo).get();
        List<Estudiante> estudiantes = Equipo.getEstudiantes();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( Estudiante.toJSONArray(estudiantes).toString(), responseHeaders, HttpStatus.OK );
    }
}

 */
