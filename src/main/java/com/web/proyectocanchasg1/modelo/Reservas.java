package com.web.proyectocanchasg1.modelo;

import com.amazonaws.util.json.JSONObject;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;
    @Column(name = "fecha_reserva")
    private String fecha;
    @Column(name = "hora_inicio")
    private int horaI;
    @Column(name = "hora_final")
    private int horaF;
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "canchas_id_canchas")
    private Canchas cancha;


    public Reservas() {
        super();
        this.fecha = null;
        this.horaF = 0;
        this.horaI = 0;
        this.usuario = null;
        this.cancha = null;
    }

    public Reservas(String fecha, int horaI, int horaF, Usuario u, Canchas c) {
        this.fecha = fecha;
        this.horaI = horaI;
        this.horaF = horaF;
        this.usuario = u;
        this.cancha = c;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdreserva() {
        return id_reserva;
    }

    public void setIdreserva(Long idreserva) {
        this.id_reserva = idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHoraI() {
        return horaI;
    }

    public void setHoraI(int horaI) {
        this.horaI = horaI;
    }

    public int getHoraF() {
        return horaF;
    }

    public void setHoraF(int horaF) {
        this.horaF = horaF;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jreserva = new JSONObject();
        jreserva.put("id", getIdreserva());
        jreserva.put("fecha", getFecha());
        jreserva.put("Hora_i", getHoraI());
        jreserva.put("Hora_f", getHoraF());
        jreserva.put("usuario", getUsuario().toString());
        return jreserva;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "id_reserva=" + id_reserva +
                ", fecha='" + fecha + '\'' +
                ", horaI=" + horaI +
                ", horaF=" + horaF +
                ", usuario=" + usuario.getNombreU() +
                ", cancha=" + cancha.getNombre() +
                '}';
    }
}
