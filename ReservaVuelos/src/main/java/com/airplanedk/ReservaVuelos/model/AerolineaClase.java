package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "aerolineaclase")
public class AerolineaClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAerolineaClase")
    private Long idAerolineaClase;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idAerolinea", nullable = false)
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "clase_idClase", nullable = false)
    private Clase clase;

    // Getters y Setters
    public Long getIdAerolineaClase() {
        return idAerolineaClase;
    }

    public void setIdAerolineaClase(Long idAerolineaClase) {
        this.idAerolineaClase = idAerolineaClase;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "AerolineaClase{" +
                "idAerolineaClase=" + idAerolineaClase +
                ", precio=" + precio +
                ", aerolinea=" + aerolinea +
                ", clase=" + clase +
                '}';
    }
}


