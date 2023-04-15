package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

import java.util.Iterator;

@Entity
public class Canchas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancha;

    private String Nombre;
    private int Horas_abierta;
    private int Horas_cierre;
    private String Fecha;

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

    public Long getIdCancha() {
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

    public void setIdCancha(Long idCancha) {
        this.idCancha = idCancha;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setHoras_abierta(int horas_abierta) {
        Horas_abierta = horas_abierta;
    }

    public void setHoras_cierre(int horas_cierre) {
        Horas_cierre = horas_cierre;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public void setValuesInsert(String nom, int HoraA, int HoraC, String Fecha){
        this.Nombre = nom;
        this.Horas_abierta = HoraA;
        this.Horas_cierre = HoraC;
        this.Fecha = Fecha;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jcancha = new JSONObject();
        jcancha.put("id", getIdCancha());
        jcancha.put("nombre", getNombre());
        jcancha.put("Hora_Apertura", getHoraA());
        jcancha.put("Hora_Close", getHoraC());
        jcancha.put("Fecha", getFecha());
        return jcancha;
    }

    public static JSONArray toJSONArray( Iterable<Canchas>cancha ) throws Exception {
        JSONArray jcancha = new JSONArray();
        Iterator<Canchas> icancha = cancha.iterator();
        while( icancha.hasNext() ) {
            Canchas c = icancha.next();
            jcancha.put( c.toJSON() );
        }
        return jcancha;
    }

}
