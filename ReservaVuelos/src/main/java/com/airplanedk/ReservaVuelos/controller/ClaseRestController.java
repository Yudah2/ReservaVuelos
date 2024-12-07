package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Clase;
import com.airplanedk.ReservaVuelos.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clase")
public class ClaseRestController {

    @Autowired
    private ClaseService claseService;

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.findAll();
    }

    @PostMapping
    public Clase creaateClase(@RequestBody Clase clase) {
        return claseService.save(clase);
    }

    @PostMapping("/bulk")
    public List<Clase> createMultipleClases(@RequestBody List<Clase> clases) {
        return claseService.saveAll(clases);
    }

    @DeleteMapping("/{id}")
    public void deleteClase(@PathVariable Long id) {
        claseService.deleteById(id);
    }
    // Otros endpoints según sea necesario
}

