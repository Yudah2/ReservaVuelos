package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
