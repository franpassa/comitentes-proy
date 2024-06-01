package org.proyecto.challenge.repository;

import org.proyecto.challenge.model.pais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
