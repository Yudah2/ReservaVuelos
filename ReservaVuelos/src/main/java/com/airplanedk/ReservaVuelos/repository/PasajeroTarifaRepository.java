package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.PasajeroTarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroTarifaRepository extends JpaRepository<PasajeroTarifa, Long> {

}
