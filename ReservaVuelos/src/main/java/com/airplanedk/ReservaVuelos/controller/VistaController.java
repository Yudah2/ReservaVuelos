package com.airplanedk.ReservaVuelos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.airplanedk.ReservaVuelos.model.Vuelo;
import com.airplanedk.ReservaVuelos.service.VueloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VistaController {

    @Autowired
    private VueloService VueloService;

    @GetMapping("/home")
    public String home() {
        return "home"; // Carga home.html
    }

    @GetMapping("/resultados")
    public String resultados(Model model) {
        List<Vuelo> vuelos = VueloService.findAll();
        model.addAttribute("vuelos", vuelos);
        vuelos.forEach(v -> System.out.println(v.getNumeroVuelo()));
        return "resultados"; // Carga resultados.html
    }

    @GetMapping("/pasajeros")
    public String pasajeros() {
        return "pasajeros"; // Carga pasajeros.html
    }

    @GetMapping("/factura")
    public String factura() {
        return "factura"; // Carga factura.html
    }
}

