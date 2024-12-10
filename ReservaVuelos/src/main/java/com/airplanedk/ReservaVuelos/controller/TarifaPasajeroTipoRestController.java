package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.TarifaPasajeroTipo;
import com.airplanedk.ReservaVuelos.service.TarifaPasajeroTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifaPasajeroTipo")
public class TarifaPasajeroTipoRestController {

    @Autowired
    public TarifaPasajeroTipoService tarifaPasajeroTipoService;

    @GetMapping
    public List<TarifaPasajeroTipo> getAllTarifaPasajeroTipo() {
        return tarifaPasajeroTipoService.findAll();
    }

    @PostMapping
    public TarifaPasajeroTipo createCiudad(@RequestBody TarifaPasajeroTipo tarifaPasajeroTipo) {
        return tarifaPasajeroTipoService.save(tarifaPasajeroTipo);
    }

    @PostMapping("/bulk")
    public List<TarifaPasajeroTipo> createMultipleCiudad(@RequestBody List<TarifaPasajeroTipo> tarifaPasajeroTipos) {
        return tarifaPasajeroTipoService.saveAll(tarifaPasajeroTipos);
    }

    @DeleteMapping("/{id}")
    public void deleteCiudad(@PathVariable Long id) {
        tarifaPasajeroTipoService.deleteById(id);
    }
}

