package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipo;

    String Nombre;
    int Estado;
    String UrlData;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idequipo")
    List<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Equipo(Long idEquipo, String nombre, int estado, String urlData) {
        this.idEquipo = idEquipo;
        Nombre = nombre;
        Estado = estado;
        UrlData = urlData;
    }

    public Equipo() {
        super();
        this.Nombre = null;
        this.Estado = 0;
        this.UrlData = null;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEstado() {
        return Estado;
    }

    public String getUrlData() {
        return UrlData;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
