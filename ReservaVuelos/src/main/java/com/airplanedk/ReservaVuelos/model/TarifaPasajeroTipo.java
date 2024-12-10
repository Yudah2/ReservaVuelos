package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tarifapasajerotipo")
public class TarifaPasajeroTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarifaPasajeroTipo")
    private Long idTarifaPasajeroTipo;

    @Column(name = "tarifa", nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifa;

    @ManyToOne
    @JoinColumn(name = "pasajerotipo_idPasajeroTipo", nullable = false)
    private PasajeroTipo pasajeroTipo;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idAerolinea", nullable = false)
    private Aerolinea aerolinea;

    // Getters y Setters
    public Long getIdTarifaPasajeroTipo() {
        return idTarifaPasajeroTipo;
    }

    public void setIdTarifaPasajeroTipo(Long idTarifaPasajeroTipo) {
        this.idTarifaPasajeroTipo = idTarifaPasajeroTipo;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public PasajeroTipo getPasajeroTipo() {
        return pasajeroTipo;
    }

    public void setPasajeroTipo(PasajeroTipo pasajeroTipo) {
        this.pasajeroTipo = pasajeroTipo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Override
    public String toString() {
        return "TarifaPasajeroTipo{" +
                "idTarifaPasajeroTipo=" + idTarifaPasajeroTipo +
                ", tarifa=" + tarifa +
                ", pasajeroTipo=" + pasajeroTipo +
                ", aerolinea=" + aerolinea +
                '}';
    }
}
