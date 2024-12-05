package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Aeropuerto;
import com.airplanedk.ReservaVuelos.service.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aeropuerto")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping
    public List<Aeropuerto> getAllAeropuerto(){
        return aeropuertoService.findAll();
    }

    @PostMapping
    public Aeropuerto createAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.save(aeropuerto);
    }

    @PostMapping("/bulk")
    public List<Aeropuerto> createMultipleAeropuertos(@RequestBody List<Aeropuerto> aeropuertos) {
        return aeropuertoService.saveAll(aeropuertos);
    }

    @DeleteMapping("/{id}")
    public void deleteAeropuerto(@PathVariable Long id) {
        aeropuertoService.deleteById(id);
    }
}
