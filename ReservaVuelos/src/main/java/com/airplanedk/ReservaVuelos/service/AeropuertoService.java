package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Aeropuerto;
import com.airplanedk.ReservaVuelos.repository.AeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService {
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public List<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }

    public Aeropuerto save(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }

    public List<Aeropuerto> saveAll(List<Aeropuerto> aeropuertos) {
        return aeropuertoRepository.saveAll(aeropuertos);
    }

    public void deleteById(Long id) {
        aeropuertoRepository.deleteById(id);
    }
}
