package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Aerolinea;
import com.airplanedk.ReservaVuelos.repository.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaService {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    public List<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }

    public Aerolinea save(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    public List<Aerolinea> saveAll(List<Aerolinea> aerolineas) {
        return aerolineaRepository.saveAll(aerolineas);
    }

    public void deleteById (Long id) {
        aerolineaRepository.deleteById(id);
    }
}
