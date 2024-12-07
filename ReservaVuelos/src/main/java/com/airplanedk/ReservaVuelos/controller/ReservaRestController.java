package com.airplanedk.ReservaVuelos.controller;


import com.airplanedk.ReservaVuelos.model.Reserva;
import com.airplanedk.ReservaVuelos.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaRestController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getReserva() {
        return reservaService.findAll();
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PostMapping("/bulk")
    public List<Reserva> createMultipleReservas(@RequestBody List<Reserva> reservas) {
        return reservaService.saveAll(reservas);
    }

    @DeleteMapping
    public void deleteReserva(@PathVariable Long id){
        reservaService.deleteById(id);
    }
}