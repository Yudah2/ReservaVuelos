package com.airplanedk.ReservaVuelos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacturaController {
    @GetMapping("/factura")
    public String factura() {
        return "factura"; // Carga factura.html
    }
}
