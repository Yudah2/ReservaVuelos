package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Asiento;
import com.airplanedk.ReservaVuelos.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService {
    @Autowired
    private AsientoRepository asientoRepository;

    public List<Asiento> findAll() {
        return asientoRepository.findAll();
    }

    public Asiento save(Asiento asiento) {
        return asientoRepository.save(asiento);
    }

    public List<Asiento> saveAll(List<Asiento> aerolineas) {
        return asientoRepository.saveAll(aerolineas);
    }

    public void deleteById (Long id) {
        asientoRepository.deleteById(id);
    }
}
