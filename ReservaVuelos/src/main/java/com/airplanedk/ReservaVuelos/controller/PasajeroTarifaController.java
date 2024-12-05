package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.PasajeroTarifa;
import com.airplanedk.ReservaVuelos.service.PasajeroTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeroTarifa")
public class PasajeroTarifaController {

    @Autowired
    private PasajeroTarifaService pasajeroTarifaService;

    @GetMapping
    public List<PasajeroTarifa> getPasajeroTarifa() {
        return pasajeroTarifaService.findAll();
    }

    @PostMapping
    public PasajeroTarifa createPasajeroTarifa(@RequestBody PasajeroTarifa pasajeroTarifa) {
        return pasajeroTarifaService.save(pasajeroTarifa);
    }

    @PostMapping("/bulk")
    public List<PasajeroTarifa> createMultiplePasajeroTarifas(@RequestBody List<PasajeroTarifa> pasajeroTarifas) {
        return pasajeroTarifaService.saveAll(pasajeroTarifas);
    }

    @DeleteMapping
    public void deletePasajeroTarifa(@PathVariable Long id){
        pasajeroTarifaService.deleteById(id);
    }
}
