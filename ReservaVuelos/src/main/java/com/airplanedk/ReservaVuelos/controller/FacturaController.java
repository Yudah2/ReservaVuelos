package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Factura;
import com.airplanedk.ReservaVuelos.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getFactura() {
        return facturaService.findAll();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @PostMapping("/bulk")
    public List<Factura> createMultipleFacturas(@RequestBody List<Factura> facturas) {
        return facturaService.saveAll(facturas);
    }

    @DeleteMapping
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteById(id);
    }
}