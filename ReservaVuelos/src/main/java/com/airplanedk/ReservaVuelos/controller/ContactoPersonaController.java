package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.ContactoPersona;
import com.airplanedk.ReservaVuelos.service.ContactoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactoPersona")
public class ContactoPersonaController {
    @Autowired
    private ContactoPersonaService contactoPersonaService;

    @GetMapping
    public List<ContactoPersona> getContactoPersonas() {
        return contactoPersonaService.findAll();
    }

    @PostMapping
    public ContactoPersona createContactoPersona(@RequestBody ContactoPersona contactoPersona) {
        return contactoPersonaService.save(contactoPersona);
    }

    @PostMapping("/bulk")
    public List<ContactoPersona> createMultipleContactoPersonas(@RequestBody List<ContactoPersona> contactoPersonas) {
        return contactoPersonaService.saveAll(contactoPersonas);
    }

    @DeleteMapping("/{id}")
    public void deleteContactoPersona(@PathVariable Long id) {
        contactoPersonaService.deleteById(id);
    }

}
