package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.AerolineaClase;
import com.airplanedk.ReservaVuelos.repository.AerolineaClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaClaseService {

    @Autowired
    private AerolineaClaseRepository aerolineaClaseRepository;

    public AerolineaClase obtenerAerolineaClase(String tipoClase, Long idVuelo) {
        return aerolineaClaseRepository.findAerolineaClaseByTipoAndVuelo(tipoClase, idVuelo).orElseThrow(() -> new IllegalArgumentException("No se encontró la aerolínea clase para el tipo " + tipoClase + " y vuelo " + idVuelo));
    }
    public List<AerolineaClase> findAll() {
        return aerolineaClaseRepository.findAll();
    }

    public AerolineaClase save(AerolineaClase aerolineaClase) {
        return aerolineaClaseRepository.save(aerolineaClase);
    }

    public List<AerolineaClase> saveAll(List<AerolineaClase> aerolineaClases) {
        return aerolineaClaseRepository.saveAll(aerolineaClases);
    }

    public void deleteById(Long id) {
        aerolineaClaseRepository.deleteById(id);
    }
}

