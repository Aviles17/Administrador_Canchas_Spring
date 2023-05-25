package com.web.proyectocanchasg1.modelo;
import com.amazonaws.util.json.JSONObject;
import jakarta.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    @OneToOne
    @JoinColumn(name = "Equipo_id_equipo")
    private Equipo equipo;

    @OneToOne
    @JoinColumn(name = "Equipo_id_equipo1")
    private Equipo equipo1;

    @OneToOne
    @JoinColumn(name = "Reserva_id_reserva")
    private Reservas reserva;


    public Grupo(){
        super();
        equipo = new Equipo();
        equipo1 = new Equipo();
        reserva = new Reservas();
    }
    public Grupo(Reservas r, Equipo e, Equipo e1) {
        equipo = e;
        equipo1 = e1;
        reserva = r;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jgrupo = new JSONObject();
        jgrupo.put("id", getIdGrupo());
        jgrupo.put("equipo_1", getEquipo());
        jgrupo.put("equipo_2", getEquipo1());
        jgrupo.put("reserva", getReserva());
        return jgrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "idGrupo=" + idGrupo +
                ", equipo=" + equipo.getNombre() +
                ", equipo1=" + equipo1.getNombre() +
                ", reserva=" + reserva.getIdreserva() +
                ", usuario_reserva=" + reserva.getUsuario() +
                '}';
    }
}
