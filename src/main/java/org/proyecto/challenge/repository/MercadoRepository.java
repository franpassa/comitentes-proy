package org.proyecto.challenge.repository;

import org.proyecto.challenge.model.mercado.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {

    List<Mercado> findByPais_id(Long id);
}
