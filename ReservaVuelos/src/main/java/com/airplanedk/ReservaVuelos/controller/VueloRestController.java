package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import com.airplanedk.ReservaVuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelo")
public class VueloRestController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloService.findAll();
    }

    @PostMapping
    public Vuelo createVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }

    @PostMapping("/bulk")
    public List<Vuelo> createMultipleVuelos(@RequestBody List<Vuelo> vuelos) {
        return vueloService.saveAll(vuelos);
    }

    @DeleteMapping("/{id}")
    public void deleteVuelo(@PathVariable Long id) {
        vueloService.deleteById(id);
    }
}
