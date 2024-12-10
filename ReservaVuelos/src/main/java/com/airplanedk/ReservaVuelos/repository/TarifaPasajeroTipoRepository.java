package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.TarifaPasajeroTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaPasajeroTipoRepository extends JpaRepository<TarifaPasajeroTipo, Long> {

    @Query(value = "SELECT a.* " +
            "FROM reservadevuelos.tarifapasajerotipo a " +
            "JOIN reservadevuelos.pasajerotipo b ON a.pasajerotipo_idPasajeroTipo = b.idPasajeroTipo " +
            "JOIN reservadevuelos.aerolinea c ON a.aerolinea_idAerolinea = c.idAerolinea " +
            "JOIN reservadevuelos.vuelo d ON c.idAerolinea = d.aerolinea_idAerolinea " +
            "WHERE b.tipo = :tipoPasajero " +
            "AND d.idVuelo = :idVuelo", nativeQuery = true)
    TarifaPasajeroTipo findByTipoPasajeroAndIdVuelo(@Param("tipoPasajero") String tipoPasajero,
                                                    @Param("idVuelo") Long idVuelo);
}

