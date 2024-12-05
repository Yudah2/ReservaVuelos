package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.AerolineaClase;
import com.airplanedk.ReservaVuelos.service.AerolineaClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aerolineaClase")
public class AerolineaClaseController {

    @Autowired
    private AerolineaClaseService aerolinaClaseService;

    @GetMapping
    public List<AerolineaClase> getAllAerolinaClases() {
        return aerolinaClaseService.findAll();
    }

    @PostMapping
    public AerolineaClase createAerolinaClase(@RequestBody AerolineaClase aerolineaClase) {
        return aerolinaClaseService.save(aerolineaClase);
    }

    @PostMapping("/bulk")
    public List<AerolineaClase> createMultipleAerolinaClases(@RequestBody List<AerolineaClase> aerolineaClases) {
        return aerolinaClaseService.saveAll(aerolineaClases);
    }

    @DeleteMapping("/{id}")
    public void deleteAerolinaClase(@PathVariable Long id) {
        aerolinaClaseService.deleteById(id);
    }
}

