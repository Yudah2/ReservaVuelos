package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

}
