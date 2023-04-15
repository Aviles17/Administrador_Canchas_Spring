package com.web.proyectocanchasg1.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "gestion")
public class Gestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestion;

    @OneToOne
    @JoinColumn(name = "Reserva_id_reserva")
    private Reservas reserva;

    @OneToOne
    @JoinColumn(name = "Canchas_id_canchas")
    private Canchas canchas;


    public Gestion(){
        super();
        this.reserva = null;
        this.canchas = null;
    }

    public Gestion(Reservas Reserva, Canchas Cancha){
        this.reserva = Reserva;
        this.canchas = Cancha;
    }





    public Long getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Long idGestion) {
        this.idGestion = idGestion;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Canchas getCanchas() {
        return canchas;
    }

    public void setCanchas(Canchas canchas) {
        this.canchas = canchas;
    }
}
