package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    @Query("SELECT v FROM Vuelo v " +
            "JOIN v.aeropuertoOrigen ao " +
            "JOIN ao.ciudad co " +
            "WHERE co.nombre = :origen " +
            "AND v.fechaSalida = :fechaSalida " +
            "AND EXISTS (" +
            "    SELECT 1 " +
            "    FROM Aeropuerto ad " +
            "    JOIN ad.ciudad cd " +
            "    WHERE v.aeropuertoDestino = ad " +
            "    AND cd.nombre = :destino" +
            ")")
    List<Vuelo> findByCriteria(
            @Param("origen") String origen,
            @Param("destino") String destino,
            @Param("fechaSalida") LocalDate fechaSalida
    );
}

