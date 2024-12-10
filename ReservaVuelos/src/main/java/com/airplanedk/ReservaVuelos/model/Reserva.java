package com.airplanedk.ReservaVuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    private LocalDate fechaReserva;

    @ManyToOne
    @JoinColumn(name = "asiento_idAsiento", nullable = false)
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "pasajero_idPasajero", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "factura_idFactura", nullable = false)
    private Factura factura;

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

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", estado='" + estado + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", asiento=" + asiento +
                ", pasajero=" + pasajero +
                '}';
    }
}
