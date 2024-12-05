package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.TarifaPasajeroTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaPasajeroTipoRepository extends JpaRepository<TarifaPasajeroTipo, Long> {

}
