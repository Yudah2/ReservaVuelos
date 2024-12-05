package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.ContactoPersona;
import com.airplanedk.ReservaVuelos.repository.ContactoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoPersonaService {
    @Autowired
    private ContactoPersonaRepository contactoPersonaRepository;

    public List<ContactoPersona> findAll() {
        return contactoPersonaRepository.findAll();
    }

    public ContactoPersona save(ContactoPersona contactoPersona) {
        return contactoPersonaRepository.save(contactoPersona);
    }

    public List<ContactoPersona> saveAll(List<ContactoPersona> contactoPersonas) {
        return contactoPersonaRepository.saveAll(contactoPersonas);
    }

    public void deleteById(Long id) {
        contactoPersonaRepository.deleteById(id);
    }

}
