package org.proyecto.challenge.service;

import org.proyecto.challenge.model.comitente.ActualizarComitenteDTO;
import org.proyecto.challenge.model.comitente.Comitente;
import org.proyecto.challenge.model.comitente.CrearComitenteDTO;
import org.proyecto.challenge.model.mercado.Mercado;
import org.proyecto.challenge.repository.ComitenteRepository;
import org.proyecto.challenge.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComitenteService {

    @Autowired
    private ComitenteRepository comitenteRepository;

    @Autowired
    private MercadoRepository mercadoRepository;

    public List<Comitente> findAll() {
        return comitenteRepository.findAll();
    }

    public Comitente findById(Long id) {
        return comitenteRepository.findById(id).orElse(null);
    }

    public Comitente save(Comitente comitente) {
        return comitenteRepository.save(comitente);
    }

    public void deleteById(Long id) {
        comitenteRepository.deleteById(id);
    }

    public Comitente updateComitente(ActualizarComitenteDTO comitenteDTO) throws Exception {
        Comitente comitente = comitenteRepository.findById(comitenteDTO.getIdComitente()).orElseThrow(() -> new Exception("Comitente no encontrado."));

        comitente.setDescripcion(comitenteDTO.getDescripcion());

        Set<Mercado> mercados = new HashSet<>();
        for (Long mercadoId : comitenteDTO.getIdMercados()) {
            Mercado mercado = mercadoRepository.findById(mercadoId)
                    .orElseThrow(() -> new Exception("Mercado no encontrado."));
            mercados.add(mercado);
        }
        comitente.setMercados(mercados);

        return comitenteRepository.save(comitente);
    }

    public Comitente crearComitente(CrearComitenteDTO comitenteDTO) throws Exception {
        Comitente comitente = new Comitente();
        comitente.setDescripcion(comitenteDTO.getDescripcion());

        Set<Mercado> mercados = new HashSet<>();
        for (Long mercadoId : comitenteDTO.getIdMercados()) {
            Mercado mercado = mercadoRepository.findById(mercadoId)
                    .orElseThrow(() -> new Exception("Mercado no encontrado."));
            mercados.add(mercado);
        }
        comitente.setMercados(mercados);

        return comitenteRepository.save(comitente);
    }
}
