package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.PasajeroTipo;
import com.airplanedk.ReservaVuelos.repository.PasajeroTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroTipoService {

    @Autowired
    private PasajeroTipoRepository pasajeroTipoRepository;

    public List<PasajeroTipo> findAll() {
        return pasajeroTipoRepository.findAll();
    }

    public PasajeroTipo save(PasajeroTipo pasajeroTipo) {
        return pasajeroTipoRepository.save(pasajeroTipo);
    }

    public List<PasajeroTipo> saveAll(List<PasajeroTipo> pasajeroTipos) {
        return pasajeroTipoRepository.saveAll(pasajeroTipos);
    }

    public void deleteById(Long id) {
        pasajeroTipoRepository.deleteById(id);
    }

}
