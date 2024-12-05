package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
