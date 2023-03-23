package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Canchas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCancha;

    String Nombre;
    int Horas_abierta;
    int Horas_cierre;
    String Fecha;

    public Canchas() {
        super();
        Nombre = null;
        Horas_abierta = 0;
        Horas_cierre = 0;
        Fecha = null;
    }
    public Canchas(String nombre, int horaA, int horaC, String fecha) {
        Nombre = nombre;
        Horas_abierta = horaA;
        Horas_cierre = horaC;
        Fecha = fecha;
    }

    public Long getIdEquipo() {
        return idCancha;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getHoraA() {
        return Horas_abierta;
    }

    public int getHoraC() {
        return Horas_cierre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setValuesInsert(String nom, int HoraA, int HoraC, String Fecha){
        this.Nombre = nom;
        this.Horas_abierta = HoraA;
        this.Horas_cierre = HoraC;
        this.Fecha = Fecha;
    }
}
