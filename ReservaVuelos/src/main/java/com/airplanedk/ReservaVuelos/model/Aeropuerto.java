package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAeropuerto", nullable = false, unique = true)
    private Long idAeropuerto;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ciudad_idCiudad", nullable = false)
    private Ciudad ciudad;

    // Getters y setters
    public Long getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(Long idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "idAeropuerto=" + idAeropuerto +
                ", nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}

