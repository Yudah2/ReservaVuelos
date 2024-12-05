package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.AerolineaClase;
import com.airplanedk.ReservaVuelos.repository.AerolineaClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaClaseService {

    @Autowired
    private AerolineaClaseRepository aerolinaClaseRepository;

    public List<AerolineaClase> findAll() {
        return aerolinaClaseRepository.findAll();
    }

    public AerolineaClase save(AerolineaClase aerolineaClase) {
        return aerolinaClaseRepository.save(aerolineaClase);
    }

    public List<AerolineaClase> saveAll(List<AerolineaClase> aerolineaClases) {
        return aerolinaClaseRepository.saveAll(aerolineaClases);
    }

    public void deleteById(Long id) {
        aerolinaClaseRepository.deleteById(id);
    }
}

