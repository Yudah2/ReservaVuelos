package com.airplanedk.ReservaVuelos.repository;

import com.airplanedk.ReservaVuelos.model.AerolineaClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AerolineaClaseRepository extends JpaRepository<AerolineaClase, Long> {
    @Query(value = """
        SELECT a 
        FROM AerolineaClase a
        JOIN a.clase b
        JOIN a.aerolinea c
        JOIN Vuelo d ON c.idAerolinea = d.aerolinea.idAerolinea
        WHERE b.tipo = :tipoClase AND d.idVuelo = :idVuelo
    """)
    Optional<AerolineaClase> findAerolineaClaseByTipoAndVuelo(@Param("tipoClase") String tipoClase,
                                                              @Param("idVuelo") Long idVuelo);
}
