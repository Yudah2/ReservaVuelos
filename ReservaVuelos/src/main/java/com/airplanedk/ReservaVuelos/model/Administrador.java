package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrador")
    private Long idAdministrador;

    @Column(name = "nivelPermiso", nullable = false, length = 50)
    private String nivelPermiso;

    @ManyToOne
    @JoinColumn(name = "persona_idPersona", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "contactopersona_idContactoPersona", nullable = false)
    private ContactoPersona contactoPersona;

    // Getters y Setters
    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNivelPermiso() {
        return nivelPermiso;
    }

    public void setNivelPermiso(String nivelPermiso) {
        this.nivelPermiso = nivelPermiso;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ContactoPersona getContactoPersona() {
        return contactoPersona;
    }

    public void setContactoPersona(ContactoPersona contactoPersona) {
        this.contactoPersona = contactoPersona;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", nivelPermiso='" + nivelPermiso + '\'' +
                ", persona=" + persona +
                ", contactoPersona=" + contactoPersona +
                '}';
    }
}

