package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Ciudad;
import com.airplanedk.ReservaVuelos.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public List<Ciudad> saveAll(List<Ciudad> ciudades) {
        return ciudadRepository.saveAll(ciudades);
    }

    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }
}
