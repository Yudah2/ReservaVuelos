package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name = "contactopersona")
public class ContactoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContactoPersona")
    private Long idContactoPersona;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    // Getters y Setters
    public Long getIdContactoPersona() {
        return idContactoPersona;
    }

    public void setIdContactoPersona(Long idContactoPersona) {
        this.idContactoPersona = idContactoPersona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ContactoPersona{" +
                "idContactoPersona=" + idContactoPersona +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
