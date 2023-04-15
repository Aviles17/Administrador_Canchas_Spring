package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreserva;
    private String fecha;
    private String horaI;
    private String horaF;
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;


    public Reservas() {
        super();
        this.fecha = null;
        this.horaF = null;
        this.horaI = null;
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reservas(String fecha, String horaI, String horaF, Long idUsuario, Usuario u) {
        this.fecha = fecha;
        this.horaI = horaI;
        this.horaF = horaF;
        this.usuario = u;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }

}
