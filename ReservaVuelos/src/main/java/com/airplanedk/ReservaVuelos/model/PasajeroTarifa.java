package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajerotarifa")
public class PasajeroTarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPasajeroTarifa")
    private Long idPasajeroTarifa;

    @ManyToOne
    @JoinColumn(name = "pasajero_idPasajero", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "tarifapasajerotipo_idTarifaPasajeroTipo", nullable = false)
    private TarifaPasajeroTipo tarifaPasajeroTipo;

    // Getters y Setters
    public Long getIdPasajeroTarifa() {
        return idPasajeroTarifa;
    }

    public void setIdPasajeroTarifa(Long idPasajeroTarifa) {
        this.idPasajeroTarifa = idPasajeroTarifa;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public TarifaPasajeroTipo getTarifaPasajeroTipo() {
        return tarifaPasajeroTipo;
    }

    public void setTarifaPasajeroTipo(TarifaPasajeroTipo tarifaPasajeroTipo) {
        this.tarifaPasajeroTipo = tarifaPasajeroTipo;
    }

    @Override
    public String toString() {
        return "PasajeroTarifa{" +
                "idPasajeroTarifa=" + idPasajeroTarifa +
                ", pasajero=" + pasajero +
                ", tarifaPasajeroTipo=" + tarifaPasajeroTipo +
                '}';
    }
}

