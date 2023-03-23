package com.web.proyectocanchasg1.modelo;


import jakarta.persistence.*;

@Entity
public class Estudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEstudiante;
    String nombre;
    String apellido;
    String correo;
    int estado;
    @ManyToOne()
    @JoinColumn(name= "idequipo")
    Equipo equipo;


    public Estudiante() {
        super();
        this.nombre = null;
        this.apellido = null;
        this.correo = null;
        this.estado = 0;
    }
    public Estudiante(String nom, String apellido, String correo, int estado) {
        this.nombre = nom;
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
    }

    public Long getId() {
        return idEstudiante;
    }
    public int getEstado() {
        return estado;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCorreo() {
        return correo;
    }
}
