package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Administrador;
import com.airplanedk.ReservaVuelos.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public List<Administrador> saveAll(List<Administrador> administradores) {
        return administradorRepository.saveAll(administradores);
    }

    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }

}
