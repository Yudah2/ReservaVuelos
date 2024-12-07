package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Ciudad;
import com.airplanedk.ReservaVuelos.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadRestController {

    @Autowired
    public CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> getAllCiudad() {
        return ciudadService.findAll();
    }

    @PostMapping
    public Ciudad createCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.save(ciudad);
    }

    @PostMapping("/bulk")
    public List<Ciudad> createMultipleCiudad(@RequestBody List<Ciudad> ciudades) {
        return ciudadService.saveAll(ciudades);
    }

    @DeleteMapping("/{id}")
    public void deleteCiudad(@PathVariable Long id) {
        ciudadService.deleteById(id);
    }
}
