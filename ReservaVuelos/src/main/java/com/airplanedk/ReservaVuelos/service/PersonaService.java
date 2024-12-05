package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Persona;
import com.airplanedk.ReservaVuelos.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> saveAll(List<Persona> personas) {
        return personaRepository.saveAll(personas);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}
