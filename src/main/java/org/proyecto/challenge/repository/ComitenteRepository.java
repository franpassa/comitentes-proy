package org.proyecto.challenge.repository;

import org.proyecto.challenge.model.comitente.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
}
