package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
