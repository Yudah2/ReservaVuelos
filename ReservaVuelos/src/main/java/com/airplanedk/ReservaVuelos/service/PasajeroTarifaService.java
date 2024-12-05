package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.PasajeroTarifa;
import com.airplanedk.ReservaVuelos.repository.PasajeroTarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroTarifaService {

    @Autowired
    private PasajeroTarifaRepository pasajeroTarifaRepository;

    public List<PasajeroTarifa> findAll() {
        return pasajeroTarifaRepository.findAll();
    }

    public PasajeroTarifa save(PasajeroTarifa pasajeroTarifa) {
        return pasajeroTarifaRepository.save(pasajeroTarifa);
    }

    public List<PasajeroTarifa> saveAll(List<PasajeroTarifa> pasajeroTarifas) {
        return pasajeroTarifaRepository.saveAll(pasajeroTarifas);
    }

    public void deleteById(Long id) {
        pasajeroTarifaRepository.deleteById(id);
    }

}
