package com.airplanedk.ReservaVuelos.controller;

import com.airplanedk.ReservaVuelos.model.Factura;
import com.airplanedk.ReservaVuelos.model.Pasajero;
import com.airplanedk.ReservaVuelos.model.Reserva;
import com.airplanedk.ReservaVuelos.repository.FacturaRepository;
import com.airplanedk.ReservaVuelos.repository.PersonaRepository;
import com.airplanedk.ReservaVuelos.repository.ReservaRepository;
import com.airplanedk.ReservaVuelos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ContactoPersonaService contactoPersonaService;

    @Autowired
    private PasajeroService pasajeroService;

    @Autowired
    private PasajeroTarifaService pasajeroTarifaService;

    @Autowired
    private VueloService vueloService;

    @Autowired
    private AsientoService asientoService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private FacturaService facturaService;

    private Reserva reserva = new Reserva();

    private Factura factura = new Factura();

    @GetMapping
    public String mostrarFormularioFactura() {
        return "factura"; // Nombre del archivo HTML en la carpeta 'templates'
    }

    @PostMapping("/registrar")
    public String registrarPago(
            @RequestParam("cardNumber") String numeroTarjeta,
            @RequestParam("expiryDate") String fechaVencimiento,
            @RequestParam("cvv") String cvv,
            @RequestParam("cardHolder") String titular,
            @RequestParam("amount") BigDecimal monto) {

        // Validar los datos (puedes agregar validaciones adicionales como el formato de la tarjeta)
        if (numeroTarjeta == null || numeroTarjeta.isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta es obligatorio");
        }

        // Crear la factura
        factura.setNumeroTarjeta(numeroTarjeta);
        factura.setFechaVencimiento(LocalDate.parse(fechaVencimiento));
        factura.setCvv(Integer.parseInt(cvv));
        factura.setTitular(titular);
        factura.setMonto(monto);
        factura.setDetalles(titular);
        factura.setFechaEmision(LocalDate.now());
        ReservaManager.getInstance().setFactura(factura);

        for (int i = 0; i < (ReservaManager.getInstance().getAllPasajeros().size()); i++) {
            //Crear la reservas
            reserva.setEstado("Reservado");
            reserva.setFechaReserva(LocalDate.now());
            reserva.setAsiento(ReservaManager.getInstance().getAsientos(i));
            reserva.setPasajero(ReservaManager.getInstance().getPasajeros(i));
            reserva.setFactura(ReservaManager.getInstance().getFactura());
            ReservaManager.getInstance().setReservas(reserva);
        }

        System.out.println(ReservaManager.getInstance().getFactura());
        System.out.println(ReservaManager.getInstance().getReservas(0));

        personaService.saveAll(ReservaManager.getInstance().getAllPersonas());
        contactoPersonaService.save(ReservaManager.getInstance().getContactoPersona());
        pasajeroService.saveAll(ReservaManager.getInstance().getAllPasajeros());
        pasajeroTarifaService.saveAll(ReservaManager.getInstance().getAllPasajeroTarifas());
        vueloService.save(ReservaManager.getInstance().getVueloSeleccionado());
        asientoService.saveAll(ReservaManager.getInstance().getAllAsientos());
        facturaService.save(ReservaManager.getInstance().getFactura());
        reservaService.saveAll(ReservaManager.getInstance().getAllReservas());

        // Redirigir a una página de confirmación (o lo que prefieras)
        return "redirect:/confirmacion";
    }
}
