package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import com.airplanedk.ReservaVuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public List<Vuelo> saveAll(List<Vuelo> vuelos) {
        return vueloRepository.saveAll(vuelos);
    }

    public void deleteById(Long id) {
        vueloRepository.deleteById(id);
    }
}
