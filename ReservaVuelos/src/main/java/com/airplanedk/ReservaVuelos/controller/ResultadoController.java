package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import com.airplanedk.ReservaVuelos.service.ReservaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
                                    @RequestParam LocalDate salida,
                                    @RequestParam String clase)
    {
        List<Vuelo> vuelos = VueloService.findByCriteria(origen, destino, salida);
        ReservaManager.getInstance().setClase(clase);

        if (vuelos.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron vuelos para los criterios especificados.");
        } else {
            model.addAttribute("vuelos", vuelos);
            model.addAttribute("mensaje", "se encontraron vuelos para los criterios especificados.");
        }
        return "resultados"; // Nombre del archivo Thymeleaf (resultados.html)
    }

    // Manejar la selección de un vuelo
    @PostMapping("/resultados/seleccionar")
    public String seleccionarVuelo(@RequestParam("idVuelo") Long idVuelo) {
        // Buscar el vuelo por su ID
        Vuelo vueloSeleccionado = VueloService.findById(idVuelo);

        // Guardar el vuelo en ReservaManager
        ReservaManager.getInstance().setVueloSeleccionado(vueloSeleccionado);
        System.out.println(ReservaManager.getInstance().getClase());
        // Redirigir a la siguiente pestaña (Pasajeros)
        return "redirect:/pasajeros";
    }
}
