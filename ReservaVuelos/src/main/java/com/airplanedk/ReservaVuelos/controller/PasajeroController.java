package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Pasajero;
import com.airplanedk.ReservaVuelos.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping
    public List<Pasajero> getPasajero() {
        return pasajeroService.findAll();
    }

    @PostMapping
    public Pasajero createPasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.save(pasajero);
    }

    @PostMapping("/bulk")
    public List<Pasajero> createMultiplePasajeros(@RequestBody List<Pasajero> pasajeros) {
        return pasajeroService.saveAll(pasajeros);
    }

    @DeleteMapping
    public void deletePasajero(@PathVariable Long id){
        pasajeroService.deleteById(id);
    }
}
