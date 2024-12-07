package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import com.airplanedk.ReservaVuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vuelo")
public class VueloRestController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public List<Vuelo> getVuelosByCriteria(
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String salida
    ) {
        // Convertir la fecha de String a LocalDate
        LocalDate fecha = LocalDate.parse(salida);
        List<Vuelo> vuelos = vueloService.findByCriteria(origen, destino, fecha);
        System.out.println("dfsdffffffffffffffffffffffffffffffffffffffffffffffffffff\n" + origen + "\t" + destino + "\t" + salida);
        System.out.println(vuelos); // Agrega esta línea para verificar los vuelos
        return vuelos;
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
