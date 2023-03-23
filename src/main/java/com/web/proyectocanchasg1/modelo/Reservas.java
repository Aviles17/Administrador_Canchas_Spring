package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.*;

@Entity
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idreserva;
    String fecha;
    int hora;
    int estado;
    String razones;
    int aceptado;

    int Equipo1;

    int Equipo2;

    @ManyToOne()
    @JoinColumn(name= "idCanchas")
    Canchas canchita;

    public Reservas(){
        super();
        this.fecha = null;
        this.hora = 0;
        this.razones = null;
        this.estado = 0;
        this.Equipo1 = 0;
        this.Equipo2 = 0;
        this.aceptado = 0;
    }
    public Reservas(String fecha, int hora, int estado, String Razones, int aceptado,int e1, int e2){
        this.fecha = fecha;
        this.hora = hora;
        this.razones = Razones;
        this.estado = estado;
        this.Equipo1 = e1;
        this.Equipo2 = e2;
        this.aceptado = aceptado;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public int getEstado() {
        return estado;
    }

    public String getRazones() {
        return razones;
    }

    public int getAceptado() {
        return aceptado;
    }

    public int getEquipo1() {
        return Equipo1;
    }

    public int getEquipo2() {
        return Equipo2;
    }
}
