package com.airplanedk.ReservaVuelos.model;

import com.airplanedk.ReservaVuelos.repository.TarifaPasajeroTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaPasajeroTipoService {

    @Autowired
    private TarifaPasajeroTipoRepository tarifaPasajeroTipoRepository;

    public List<TarifaPasajeroTipo> findAll() {
        return tarifaPasajeroTipoRepository.findAll();
    }

    public TarifaPasajeroTipo save(TarifaPasajeroTipo tarifaPasajeroTipo) {
        return tarifaPasajeroTipoRepository.save(tarifaPasajeroTipo);
    }

    public List<TarifaPasajeroTipo> saveAll(List<TarifaPasajeroTipo> tarifaPasajeroTipos) {
        return tarifaPasajeroTipoRepository.saveAll(tarifaPasajeroTipos);
    }

    public void deleteById(Long id) {
        tarifaPasajeroTipoRepository.deleteById(id);
    }
}