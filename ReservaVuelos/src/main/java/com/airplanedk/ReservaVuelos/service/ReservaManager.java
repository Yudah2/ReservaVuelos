package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ReservaManager {
    // Instancia única de la clase
    private static ReservaManager instance;

    // Atributos de la reserva
    @Getter @Setter private Vuelo vueloSeleccionado;
    @Getter @Setter private ContactoPersona contactoPersona;
    private List<Persona> personas;
    private List<PasajeroTarifa> pasajeroTarifas;
    private List<Pasajero> pasajeros;
    private List<Asiento> asientos;
    private List<Reserva> reservas;
    @Getter @Setter private Factura factura;
    @Getter @Setter private String clase;

    // Constructor privado para evitar la creación de nuevas instancias
    private ReservaManager() {
        pasajeroTarifas = new ArrayList<>();
        personas = new ArrayList<>();
        pasajeros = new ArrayList<>();
        asientos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // Método para obtener la instancia única de la clase
    public static ReservaManager getInstance() {
        if (instance == null) {
            synchronized (ReservaManager.class) {
                if (instance == null) {
                    instance = new ReservaManager();
                }
            }
        }
        return instance;
    }

    // Método para reiniciar los datos de la reserva
    public void reset() {
        vueloSeleccionado = null;
        contactoPersona = null;
        pasajeroTarifas.clear();
        personas.clear();
        pasajeros.clear();
        asientos.clear();
        reservas.clear();
        factura = null;
        clase = null;
    }

    // Validar si la reserva está completa
    public boolean isReservaCompleta() {
        return vueloSeleccionado != null && contactoPersona != null && !pasajeros.isEmpty();
    }

    public void setPersonas(Persona personas) {
        (this.personas).add(personas) ;
    }

    public Persona getPersonas(int indicePersona) {
        return personas.get(indicePersona);
    }

    public List<Persona> getAllPersonas() {
        return personas;

    }
    public Pasajero getPasajeros(int indicePasajero) {
        return pasajeros.get(indicePasajero);
    }

    public List<Pasajero> getAllPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero pasajeros) {
        (this.pasajeros).add(pasajeros);
    }

    public PasajeroTarifa getPasajeroTarifas(int indicePasajero) {
        return pasajeroTarifas.get(indicePasajero);
    }

    public List<PasajeroTarifa> getAllPasajeroTarifas() {
        return pasajeroTarifas;
    }

    public void setPasajeroTarifas(PasajeroTarifa pasajeroTarifas) {
        (this.pasajeroTarifas).add(pasajeroTarifas);
    }

    public Asiento getAsientos(int idAsiento) {
        return asientos.get(idAsiento);
    }

    public List<Asiento> getAllAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento asientos) {
        (this.asientos).add(asientos);
    }

    public Reserva getReservas(int idReserva) {
        return reservas.get(idReserva);
    }

    public List<Reserva> getAllReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        (this.reservas).add(reservas);
    }
}

