package com.airplanedk.ReservaVuelos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmacionController {

    @GetMapping("/confirmacion")
    public String mostrarConfirmacion() {
        return "confirmacion"; // Este debe ser el nombre de tu archivo confirmacion.html
    }
}

