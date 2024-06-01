package org.proyecto.challenge.controller;

import org.proyecto.challenge.model.estadisticas.EstadisticaPais;
import org.proyecto.challenge.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/stats")
    public List<EstadisticaPais> obtenerEstadisticas() {
        return estadisticasService.getEstadisticas();
    }
}
