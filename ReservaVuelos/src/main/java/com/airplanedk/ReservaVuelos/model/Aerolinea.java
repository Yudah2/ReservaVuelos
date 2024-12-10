package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aerolinea")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAerolinea")
    private Long idAerolinea;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "pais")
    private String pais;
    private String contacto;

    // Getters y setters
    public Long getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Long idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Aerolinea{" +
                "idAerolinea=" + idAerolinea +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", pais='" + pais + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
