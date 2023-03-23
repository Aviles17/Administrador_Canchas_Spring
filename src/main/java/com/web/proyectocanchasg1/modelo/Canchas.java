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
    int HoraA;
    int HoraC;
    String Fecha;

    public Canchas() {
        super();
        Nombre = null;
        HoraA = 0;
        HoraC = 0;
        Fecha = null;
    }
    public Canchas(String nombre, int horaA, int horaC, String fecha) {
        Nombre = nombre;
        HoraA = horaA;
        HoraC = horaC;
        Fecha = fecha;
    }

    public Long getIdEquipo() {
        return idCancha;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getHoraA() {
        return HoraA;
    }

    public int getHoraC() {
        return HoraC;
    }

    public String getFecha() {
        return Fecha;
    }
}
