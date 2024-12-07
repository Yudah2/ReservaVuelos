package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ResultadoController {
    @Autowired
    private com.airplanedk.ReservaVuelos.service.VueloService VueloService;

    @GetMapping("/resultados")
    public String mostrarResultados(Model model,
                                    @RequestParam String origen,
                                    @RequestParam String destino,
                                    @RequestParam LocalDate salida) {
        List<Vuelo> vuelos = VueloService.findByCriteria(origen, destino, salida);
        System.out.println("dfsdffffffffffffffffffffffffffffffffffffffffffffffffffff\n" + origen + "\t" + destino + "\t" + salida);
        System.out.println(vuelos);
        if (vuelos.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron vuelos para los criterios especificados.");
        } else {
            model.addAttribute("vuelos", vuelos);
            model.addAttribute("mensaje", "se encontraron vuelos para los criterios especificados.");
        }
        return "resultados"; // Nombre del archivo Thymeleaf (resultados.html)
    }
}
