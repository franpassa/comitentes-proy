package org.proyecto.challenge.controller;

import org.proyecto.challenge.model.comitente.ActualizarComitenteDTO;
import org.proyecto.challenge.model.comitente.Comitente;
import org.proyecto.challenge.model.comitente.CrearComitenteDTO;
import org.proyecto.challenge.service.ComitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comitentes")
public class ComitenteController {
    @Autowired
    private ComitenteService comitenteService;

    @GetMapping("/obtenerComitentes")
    public List<Comitente> obtenerComitentes() {
        return comitenteService.findAll();
    }

    @GetMapping("/obtenerComitente/{id}")
    public ResponseEntity<Comitente> obtenerComitente(@PathVariable Long id) {
        Comitente comitente = comitenteService.findById(id);
        if (comitente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comitente);
    }

    @PostMapping("/crearComitente")
    public ResponseEntity<Object> crearComitente(@RequestBody CrearComitenteDTO comitente) {
        try {
            // Verificar si el comitente ya existe antes de crearlo
            if (comitenteService.existsByDescripcion(comitente.getDescripcion())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El comitente ya existe.");
            }

            Comitente comitenteCreado = comitenteService.crearComitente(comitente);
            return ResponseEntity.ok(comitenteCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/actualizarComitente")
    public ResponseEntity<Object> actualizarComitente(@RequestBody ActualizarComitenteDTO comitenteRequestBody) {
        try {
            Comitente comitenteActualizado = comitenteService.updateComitente(comitenteRequestBody);
            return ResponseEntity.ok(comitenteActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarComitente/{id}")
    public ResponseEntity<Void> eliminarComitente(@PathVariable Long id) {
        Comitente comitente = comitenteService.findById(id);
        if (comitente == null) {
            return ResponseEntity.notFound().build();
        }
        comitenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
