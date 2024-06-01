package org.proyecto.challenge.service;

import org.proyecto.challenge.model.comitente.Comitente;
import org.proyecto.challenge.model.mercado.CrearMercadoDTO;
import org.proyecto.challenge.model.mercado.Mercado;
import org.proyecto.challenge.repository.MercadoRepository;
import org.proyecto.challenge.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    public List<Mercado> obtenerMercados() {
        return mercadoRepository.findAll();
    }

    public Optional<Mercado> obtenerMercado(Long id) {
        return mercadoRepository.findById(id);
    }

    public Mercado crearMercado(CrearMercadoDTO mercadoDTO) throws Exception {
        Mercado mercadoCreado = new Mercado();

        mercadoCreado.setCodigo(mercadoDTO.getCodigo());
        mercadoCreado.setDescripcion(mercadoDTO.getDescripcion());
        mercadoCreado.setPais(paisRepository.findById(mercadoCreado.getPais().getId()).orElseThrow(() -> new Exception("Pais no encontrado.")));
        return mercadoCreado;
    }
}
