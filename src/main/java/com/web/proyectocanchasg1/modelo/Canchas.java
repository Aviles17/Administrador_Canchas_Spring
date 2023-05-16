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
    private Long idCanchas;

    private String Nombre_canchas;
    private int Hora_abierta;
    private int Hora_cerrado;
    private String Fecha_canchas;

    public Canchas() {
        super();
        Nombre_canchas = null;
        Hora_abierta = 0;
        Hora_cerrado = 0;
        Fecha_canchas = null;
    }
    public Canchas(String nombre, int hora_a, int hora_c, String fecha) {
        Nombre_canchas = nombre;
        Hora_abierta = hora_a;
        Hora_cerrado = hora_c;
        Fecha_canchas = fecha;
    }

    public Long getIdCancha() {
        return idCanchas;
    }

    public String getNombre() {
        return Nombre_canchas;
    }

    public int getHoraA() {
        return Hora_abierta;
    }

    public int getHoraC() {
        return Hora_cerrado;
    }

    public String getFecha() {
        return Fecha_canchas;
    }

    public void setIdCancha(Long idCancha) {
        this.idCanchas = idCancha;
    }

    public void setNombre(String nombre) {
        Nombre_canchas = nombre;
    }
    public void setFecha(String fecha) {
        Fecha_canchas = fecha;
    }
    public void setHora_abierta(int hora_a) {
        Hora_abierta = hora_a;
    }

    public void setHora_cerrado(int hora_c) {
        Hora_cerrado = hora_c;
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

    @Override
    public String toString() {
        return "Canchas{" +
                "idCanchas=" + idCanchas +
                ", Nombre_canchas='" + Nombre_canchas + '\'' +
                ", Hora_abierta=" + Hora_abierta +
                ", Hora_cerrado=" + Hora_cerrado +
                ", Fecha_canchas='" + Fecha_canchas + '\'' +
                '}';
    }
}
