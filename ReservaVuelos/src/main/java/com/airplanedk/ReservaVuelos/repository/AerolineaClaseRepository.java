package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.AerolineaClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaClaseRepository extends JpaRepository<AerolineaClase, Long> {

}
