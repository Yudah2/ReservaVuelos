package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository <Asiento, Long>{

}
