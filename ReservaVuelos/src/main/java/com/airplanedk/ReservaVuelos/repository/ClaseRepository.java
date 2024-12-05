package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long>{

}
