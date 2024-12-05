package com.airplanedk.ReservaVuelos.service;

import com.airplanedk.ReservaVuelos.model.Factura;
import com.airplanedk.ReservaVuelos.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> saveAll(List<Factura> facturas) {
        return facturaRepository.saveAll(facturas);
    }

    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}
