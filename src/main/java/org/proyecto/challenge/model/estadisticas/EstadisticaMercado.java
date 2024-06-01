package org.proyecto.challenge.model.estadisticas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class EstadisticaMercado {
    private String code;
    private BigDecimal percentage;
}