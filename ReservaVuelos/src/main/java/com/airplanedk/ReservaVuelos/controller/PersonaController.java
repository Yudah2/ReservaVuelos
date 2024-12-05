package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Persona;
import com.airplanedk.ReservaVuelos.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersona() {
        return personaService.findAll();
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PostMapping("/bulk")
    public List<Persona> createMultiplePersonas(@RequestBody List<Persona> personas) {
        return personaService.saveAll(personas);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deleteById(id);
    }

}
