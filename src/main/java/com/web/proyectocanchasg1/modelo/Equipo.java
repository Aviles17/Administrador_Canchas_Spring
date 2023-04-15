package com.web.proyectocanchasg1.modelo;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;
import jakarta.persistence.*;

import java.util.Iterator;


@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    private String Nombre;

    public Equipo(Long idEquipo, String nombre, int estado, String urlData) {
        this.idEquipo = idEquipo;
        Nombre = nombre;
    }

    public Equipo() {
        super();
        this.Nombre = null;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jequipo = new JSONObject();
        jequipo.put("id", getIdEquipo());
        jequipo.put("nombre", getNombre());
        return jequipo;
    }

    public static JSONArray toJSONArray(Iterable<Equipo> equipos ) throws Exception {
        JSONArray jequipo = new JSONArray();
        Iterator<Equipo> iequipo = equipos.iterator();
        while( iequipo.hasNext() ) {
            Equipo e = iequipo.next();
            jequipo.put( e.toJSON() );
        }
        return jequipo;
    }
}
