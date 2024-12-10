package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.*;
import com.airplanedk.ReservaVuelos.service.AerolineaClaseService;
import com.airplanedk.ReservaVuelos.service.ReservaManager;
import com.airplanedk.ReservaVuelos.service.TarifaPasajeroTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pasajeros")
public class PasajeroController {

    @Autowired
    public TarifaPasajeroTipoService tarifaPasajeroTipoService;

    @Autowired
    public AerolineaClaseService aerolineaClaseService;

    @GetMapping
    public String mostrarFormularioPasajeros() {
        return "pasajeros"; // Nombre del archivo HTML en la carpeta 'templates'
    }

    @PostMapping("/guardar")
    public String guardarPasajeros(
            @RequestParam("email") String email,
            @RequestParam("confirmEmail") String confirmEmail,
            @RequestParam("phone") String phone,
            @RequestParam("passengers[0].persona.name") List<String> names,
            @RequestParam("passengers[0].persona.lastname") List<String> lastnames,
            @RequestParam("passengers[0].gender") List<String> genders,
            @RequestParam("passengers[0].persona.ci") List<String> cis,
            @RequestParam("passengers[0].persona.birthday") List<String> birthdays,
            @RequestParam("passengers[0].categoria") List<String> categorias) {

        // Validar que los correos coincidan
        if (!email.equals(confirmEmail)) {
            throw new IllegalArgumentException("Los correos electrónicos no coinciden");
        }

        // Crear y guardar ContactoPersona
        ContactoPersona contactoPersona = new ContactoPersona();
        contactoPersona.setEmail(email);
        contactoPersona.setTelefono(Integer.parseInt(phone));
        ReservaManager.getInstance().setContactoPersona(contactoPersona);


        System.out.println(names);

        AerolineaClase aerolineaClase = aerolineaClaseService.obtenerAerolineaClase(ReservaManager.getInstance().getClase(), ReservaManager.getInstance().getVueloSeleccionado().getIdVuelo());

        // Guardar cada persona y su relación con pasajero
        for (int i = 0; i < names.size(); i++) {
            // Crear y guardar Persona
            Persona persona = new Persona();
            persona.setNombre(names.get(i));
            persona.setApellido(lastnames.get(i));
            persona.setGenero(genders.get(i));
            persona.setDocumentoIdentidad(cis.get(i));
            persona.setFechaNacimiento(LocalDate.parse(birthdays.get(i)));
            ReservaManager.getInstance().setPersonas(persona);

            // Crear y guardar Pasajero
            Pasajero pasajero = new Pasajero();
            pasajero.setTipo(categorias.get(i)); // Asignar tipo según la categoría
            pasajero.setPersona(ReservaManager.getInstance().getPersonas(i));
            pasajero.setContactoPersona(ReservaManager.getInstance().getContactoPersona());
            ReservaManager.getInstance().setPasajeros(pasajero);


            TarifaPasajeroTipo tarifaPasajeroTipo = tarifaPasajeroTipoService.obtenerTarifaPorTipoYVuelo(categorias.get(i), ReservaManager.getInstance().getVueloSeleccionado().getIdVuelo());
            PasajeroTarifa pasajeroTarifa = new PasajeroTarifa();
            pasajeroTarifa.setPasajero(pasajero);
            pasajeroTarifa.setTarifaPasajeroTipo(tarifaPasajeroTipo);
            ReservaManager.getInstance().setPasajeroTarifas(pasajeroTarifa);
            System.out.println(tarifaPasajeroTipo);

            Asiento asiento = new Asiento();
            asiento.setNumero("9C" + " - " + ReservaManager.getInstance().getClase().substring(0, 3).toUpperCase());
            asiento.setEstado("Espera");
            asiento.setVuelo(ReservaManager.getInstance().getVueloSeleccionado());
            asiento.setAerolineaClase(aerolineaClase);
            ReservaManager.getInstance().setAsientos(asiento);
        }

        System.out.println(ReservaManager.getInstance().getVueloSeleccionado());
        System.out.println(aerolineaClase);
        System.out.println(ReservaManager.getInstance().getAsientos(0));

        System.out.println(ReservaManager.getInstance().getPersonas(0));
        System.out.println(ReservaManager.getInstance().getContactoPersona());
        System.out.println(ReservaManager.getInstance().getPasajeros(0));

        System.out.println(ReservaManager.getInstance().getPasajeroTarifas(0));

        return "redirect:/factura"; // Redirigir a una página de confirmación
    }
}

