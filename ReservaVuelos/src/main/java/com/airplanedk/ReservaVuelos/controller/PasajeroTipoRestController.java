package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.PasajeroTipo;
import com.airplanedk.ReservaVuelos.service.PasajeroTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeroTipo")
public class PasajeroTipoRestController {

    @Autowired
    private PasajeroTipoService pasajeroTipoService;

    @GetMapping
    public List<PasajeroTipo> getPasajeroTipos() {
        return pasajeroTipoService.findAll();
    }

    @PostMapping
    public PasajeroTipo createPasajeroTipo(@RequestBody PasajeroTipo pasajeroTipo) {
        return pasajeroTipoService.save(pasajeroTipo);
    }

    @PostMapping("/bulk")
    public List<PasajeroTipo> createMultiplePasajeroTipos(@RequestBody List<PasajeroTipo> pasajeroTipos) {
        return pasajeroTipoService.saveAll(pasajeroTipos);
    }

    @DeleteMapping
    public void deletePasajeroTipo(@PathVariable Long id){
        pasajeroTipoService.deleteById(id);
    }
}
