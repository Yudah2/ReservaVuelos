package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Aerolinea;
import com.airplanedk.ReservaVuelos.service.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aerolinea")
public class AerolineaRestController {

    @Autowired
    private AerolineaService aerolineaService;

    @GetMapping
    public List<Aerolinea> getAllAerolina() {
        return aerolineaService.findAll();
    }

    @PostMapping
    public Aerolinea createAerolinea(@RequestBody Aerolinea aerolinea) {
        return aerolineaService.save(aerolinea);
    }

    @PostMapping("/bulk")
    public List <Aerolinea> createMultipleAerolineas(@RequestBody List<Aerolinea> aerolineas) {
        return aerolineaService.saveAll(aerolineas);
    }

    @DeleteMapping("/{id}")
    public void deleteAerolina(@PathVariable Long id) {
        aerolineaService.deleteById(id);
    }
}
