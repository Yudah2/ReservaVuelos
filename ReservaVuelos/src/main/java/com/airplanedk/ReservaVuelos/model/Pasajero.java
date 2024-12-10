package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPasajero")
    private Long idPasajero;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "persona_idPersona", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "contactopersona_idContactoPersona", nullable = false)
    private ContactoPersona contactoPersona;

    // Getters y Setters
    public Long getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Long idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "Pasajero{" +
                "idPasajero=" + idPasajero +
                ", tipo='" + tipo + '\'' +
                ", persona=" + persona +
                ", contactoPersona=" + contactoPersona +
                '}';
    }



}

