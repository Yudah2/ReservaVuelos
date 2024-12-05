package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.PasajeroTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroTipoRepository extends JpaRepository<PasajeroTipo, Long> {

}
