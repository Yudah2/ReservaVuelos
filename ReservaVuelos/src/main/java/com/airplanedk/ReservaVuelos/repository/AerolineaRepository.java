package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {

}