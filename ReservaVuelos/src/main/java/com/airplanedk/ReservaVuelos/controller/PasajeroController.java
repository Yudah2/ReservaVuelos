package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.ContactoPersona;
import com.airplanedk.ReservaVuelos.model.Pasajero;
import com.airplanedk.ReservaVuelos.model.Persona;
import com.airplanedk.ReservaVuelos.repository.ContactoPersonaRepository;
import com.airplanedk.ReservaVuelos.repository.PasajeroRepository;
import com.airplanedk.ReservaVuelos.repository.PersonaRepository;
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
    private PersonaRepository personaRepository;

    @Autowired
    private ContactoPersonaRepository contactoPersonaRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;

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
        ContactoPersona contactoGuardado = contactoPersonaRepository.save(contactoPersona);

        System.out.println(names);


        // Guardar cada persona y su relación con pasajero
        for (int i = 0; i < names.size(); i++) {
            // Crear y guardar Persona
            Persona persona = new Persona();
            persona.setNombre(names.get(i));
            persona.setApellido(lastnames.get(i));
            persona.setGenero(genders.get(i));
            persona.setDocumentoIdentidad(cis.get(i));
            persona.setFechaNacimiento(LocalDate.parse(birthdays.get(i)));
            Persona personaGuardada = personaRepository.save(persona);

            // Crear y guardar Pasajero
            Pasajero pasajero = new Pasajero();
            pasajero.setTipo(obtenerTipoPasajero(categorias.get(i))); // Asignar tipo según la categoría
            pasajero.setPersona(personaGuardada);
            pasajero.setContactoPersona(contactoGuardado);
            pasajeroRepository.save(pasajero);
        }

        return "redirect:/confirmacion"; // Redirigir a una página de confirmación
    }

    /**
     * Método auxiliar para convertir la categoría en el tipo de pasajero.
     */
    private String obtenerTipoPasajero(String categoria) {
        switch (categoria) {
            case "1":
                return "Adulto";
            case "2":
                return "Niño";
            case "3":
                return "Infante";
            default:
                throw new IllegalArgumentException("Categoría desconocida: " + categoria);
        }
    }
}

