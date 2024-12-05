package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Pasajero;
import com.airplanedk.ReservaVuelos.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    public List<Pasajero> saveAll(List<Pasajero> pasajeros) {
        return pasajeroRepository.saveAll(pasajeros);
    }

    public void deleteById(Long id) {
        pasajeroRepository.deleteById(id);
    }
}
