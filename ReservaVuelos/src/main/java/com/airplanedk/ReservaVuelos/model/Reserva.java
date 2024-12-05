package com.airplanedk.ReservaVuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long idReserva;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "fechaReserva", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaReserva;

    @ManyToOne
    @JoinColumn(name = "asiento_idAsiento", nullable = false)
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "pasajero_idPasajero", nullable = false)
    private Pasajero pasajero;

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
