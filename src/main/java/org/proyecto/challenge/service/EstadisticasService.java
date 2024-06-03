package org.proyecto.challenge.service;

import org.proyecto.challenge.model.comitente.Comitente;
import org.proyecto.challenge.model.mercado.Mercado;
import org.proyecto.challenge.model.pais.Pais;
import org.proyecto.challenge.model.estadisticas.EstadisticaPais;
import org.proyecto.challenge.model.estadisticas.EstadisticaMercado;
import org.proyecto.challenge.repository.ComitenteRepository;
import org.proyecto.challenge.repository.MercadoRepository;
import org.proyecto.challenge.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EstadisticasService {

    @Autowired
    private ComitenteRepository comitenteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private MercadoRepository mercadoRepository;

    public List<EstadisticaPais> getEstadisticas() {
        // Busco comitentes y mercados a la base de datos
        List<Comitente> comitentes = comitenteRepository.findAll();
        List<Mercado> mercados = mercadoRepository.findAll();

        // Mapeo por pais para hacer mas eficiente la busqueda
        Map<Long, List<Mercado>> mercadosPorPaisMap = mercados.stream()
                .collect(Collectors.groupingBy(mercado -> mercado.getPais().getId()));

        // Calculo el número total de comitentes
        long numeroFinalComitentes = comitentes.size();

        // Calculo las estadísticas para cada país
        return paisRepository.findAll().stream().map(pais -> {

                    List<Mercado> mercadosPorPais = mercadosPorPaisMap.getOrDefault(pais.getId(), Collections.emptyList());

                    List<EstadisticaMercado> estadisticasMercados = mercadosPorPais.stream().map(mercado -> {

                                // Se podría haber hecho mas facil si se agregaba la lista de comitentes en el mercado, pero lo dejé así.
                                long cantComitentesDelMercado = comitentes.stream()
                                        .filter(comitente -> comitente.getMercados().contains(mercado))
                                        .count();

                                // Calculo porcentaje
                                double porcentaje = (cantComitentesDelMercado * 100.0) / numeroFinalComitentes;

                                BigDecimal porcentajeRedondeado = BigDecimal.valueOf(porcentaje).setScale(2, RoundingMode.HALF_UP);

                                return new EstadisticaMercado(mercado.getCodigo(), porcentajeRedondeado);

                            }).collect(Collectors.toList());

                    return new EstadisticaPais(pais.getNombre(), estadisticasMercados);}).collect(Collectors.toList());
    }

    /*
    public List<EstadisticaPais> getEstadisticas() {
        List<EstadisticaPais> estadisticas = new ArrayList<>();

        // Obtengo la cantidad de clientes final (teniendo en cuenta que un comitente puede pertenecer a dos mercados)
        long numeroFinalComitentes = comitenteRepository.findAll().stream()
                .mapToLong(comitente -> comitente.getMercados().size())
                .sum();

        // Obtengo paises
        List<Pais> paises = paisRepository.findAll();

        // Calculo las estadísticas para cada país
        for (Pais pais : paises) {
            List<Mercado> mercadosPorPais = mercadoRepository.findByPais_id(pais.getId());

            // Calculo las estadísticas de cada mercado
            List<EstadisticaMercado> estadisticasMercados = mercadosPorPais.stream()
                    .map(mercado -> {

                        // Se podría haber hecho mas facil si se agregaba la lista de comitentes en el mercado, pero lo dejé así.
                        long cantComitentesDelMercado = comitenteRepository.findAll().stream()
                                .filter(comitente -> comitente.getMercados().contains(mercado))
                                .count();

                        double porcentaje = (cantComitentesDelMercado * 100.0) / numeroFinalComitentes;

                        //Redondeo el porcentaje para que se vea mas lindo en el json del endpoint.
                        BigDecimal porcentajeRedondeado = BigDecimal.valueOf(porcentaje).setScale(2, RoundingMode.HALF_UP);

                        return new EstadisticaMercado(mercado.getCodigo(), porcentajeRedondeado);
                    })
                    .collect(Collectors.toList());

            estadisticas.add(new EstadisticaPais(pais.getNombre(), estadisticasMercados));
        }

        return estadisticas;
    }*/


}
