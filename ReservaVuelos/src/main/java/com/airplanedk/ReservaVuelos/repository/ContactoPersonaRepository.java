package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.ContactoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoPersonaRepository extends JpaRepository<ContactoPersona, Long> {

}
