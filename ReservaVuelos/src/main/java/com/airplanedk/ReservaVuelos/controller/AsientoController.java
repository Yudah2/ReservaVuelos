package com.airplanedk.ReservaVuelos.controller;


import com.airplanedk.ReservaVuelos.model.Asiento;
import com.airplanedk.ReservaVuelos.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asiento")
public class AsientoController {

    @Autowired
    private AsientoService asientoService;

    @GetMapping
    public List<Asiento> getAllAsiento() {
        return asientoService.findAll();
    }

    @PostMapping
    public Asiento createAsiento(@RequestBody Asiento aerolinea) {
        return asientoService.save(aerolinea);
    }

    @PostMapping("/bulk")
    public List <Asiento> createMultipleAsiento(@RequestBody List<Asiento> aerolineas) {
        return asientoService.saveAll(aerolineas);
    }

    @DeleteMapping("/{id}")
    public void deleteAsiento(@PathVariable Long id) {
        asientoService.deleteById(id);
    }

}
