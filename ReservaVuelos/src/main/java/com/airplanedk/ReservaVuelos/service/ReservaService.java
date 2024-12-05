package com.airplanedk.ReservaVuelos.service;


import com.airplanedk.ReservaVuelos.model.Reserva;
import com.airplanedk.ReservaVuelos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> saveAll(List<Reserva> reservas) {
        return reservaRepository.saveAll(reservas);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

}