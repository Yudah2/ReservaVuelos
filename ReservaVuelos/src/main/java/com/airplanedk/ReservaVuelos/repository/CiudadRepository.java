package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository <Ciudad, Long> {

}
