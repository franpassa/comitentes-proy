package org.proyecto.challenge.model.estadisticas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EstadisticaPais {

    private String country;

    private List<EstadisticaMercado> markets;
}
