package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
