package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCiudad", nullable = false, unique = true)
    private Long idCiudad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Getters y setters
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "idCiudad=" + idCiudad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


