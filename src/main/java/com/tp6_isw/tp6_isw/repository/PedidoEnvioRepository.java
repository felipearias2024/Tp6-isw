package com.tp6_isw.tp6_isw.repository;

import com.tp6_isw.tp6_isw.business.domain.PedidoEnvio;
import com.tp6_isw.tp6_isw.business.domain.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoEnvioRepository extends JpaRepository<PedidoEnvio, Long> {

    PedidoEnvio save(PedidoEnvio pedidoEnvio);

    @Query(value = "SELECT email FROM transportista " +
            "WHERE EXISTS (SELECT 1 FROM jsonb_array_elements_text(zona_cobertura::jsonb->'provincia') AS provincia " +
            "WHERE provincia = :provinciaRetiro) "+
            "AND EXISTS (SELECT 1 FROM jsonb_array_elements_text(zona_cobertura::jsonb->'localidades') AS localidad " +
            "WHERE localidad = :localidadRetiro) " +
            "AND EXISTS (SELECT 1 FROM jsonb_array_elements_text(zona_cobertura::jsonb->'localidades') AS localidad " +
            "WHERE localidad = :localidadEntrega)", nativeQuery = true)
    List<String> findTransportistasByLocalidad(@Param("provinciaRetiro") String provinciaRetiro, @Param("localidadRetiro") String localidadRetiro, @Param("localidadEntrega") String localidadEntrega);
}
