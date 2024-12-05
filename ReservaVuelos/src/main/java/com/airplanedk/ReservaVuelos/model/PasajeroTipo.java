package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajerotipo")
public class PasajeroTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPasajeroTipo")
    private Long idPasajeroTipo;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    // Getters y Setters
    public Long getIdPasajeroTipo() {
        return idPasajeroTipo;
    }

    public void setIdPasajeroTipo(Long idPasajeroTipo) {
        this.idPasajeroTipo = idPasajeroTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

