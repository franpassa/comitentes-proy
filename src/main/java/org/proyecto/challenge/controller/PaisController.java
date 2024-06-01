package org.proyecto.challenge.controller;

import org.proyecto.challenge.model.pais.Pais;
import org.proyecto.challenge.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping("/obtenerPaises")
    public List<Pais> obtenerPaisesPaises() {
        return paisRepository.findAll();
    }

    @GetMapping("/obtenerPais/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
