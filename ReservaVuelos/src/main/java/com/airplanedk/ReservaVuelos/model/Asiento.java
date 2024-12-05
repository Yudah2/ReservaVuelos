package com.airplanedk.ReservaVuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "asiento")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsiento")
    private Long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vuelo_idVuelo", nullable = false)
    @JsonIgnore
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aerolinaclase_idAerolinaClase", nullable = false)
    @JsonIgnore
    private AerolineaClase aerolineaClase;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public AerolineaClase getAerolineaClase() {
        return aerolineaClase;
    }

    public void setAerolineaClase(AerolineaClase aerolineaClase) {
        this.aerolineaClase = aerolineaClase;
    }
}
