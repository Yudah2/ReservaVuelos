package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

}
