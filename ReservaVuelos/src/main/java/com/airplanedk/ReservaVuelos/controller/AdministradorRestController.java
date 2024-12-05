package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Administrador;
import com.airplanedk.ReservaVuelos.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorRestController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> getAllAdminstradores() {
        return administradorService.findAll();
    }

    @PostMapping
    public Administrador createAdministrador(@RequestBody Administrador administrador) {
        return administradorService.save(administrador);
    }

    @PostMapping("/bulk")
    public List<Administrador> createMultipleAdministradores(@RequestBody List<Administrador> administradores) {
        return administradorService.saveAll(administradores);
    }

    @DeleteMapping
    public void deleteAdministrador(@PathVariable Long id) {
        administradorService.deleteById(id);
    }
}
