package org.proyecto.challenge.controller;

import org.proyecto.challenge.model.mercado.CrearMercadoDTO;
import org.proyecto.challenge.model.mercado.Mercado;
import org.proyecto.challenge.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mercados")
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping("/api/obtenerMercados")
    public List<Mercado> obtenerMercados() {
        return mercadoService.obtenerMercados();
    }

    @GetMapping("/api/obtenerMercado/{id}")
    public ResponseEntity<Mercado> obtenerMercado(@PathVariable Long id) {
        Optional<Mercado> mercado = mercadoService.obtenerMercado(id);
        return mercado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/crearMercado")
    public ResponseEntity<Object> crearMercado(@RequestBody CrearMercadoDTO mercado) {
        try {
            Mercado mercadoCreado = mercadoService.crearMercado(mercado);
            return ResponseEntity.status(HttpStatus.CREATED).body(mercadoCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
