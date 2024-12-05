package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Clase;
import com.airplanedk.ReservaVuelos.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> findAll() {
        return claseRepository.findAll();
    }

    public Clase save(Clase clase) {
        return claseRepository.save(clase);
    }

    public List<Clase> saveAll(List<Clase> clases) {
        return claseRepository.saveAll(clases);
    }

    public void deleteById(Long id) {
        claseRepository.deleteById(id);
    }
    // Otros métodos según sea necesario
}
