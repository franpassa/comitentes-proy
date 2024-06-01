package org.proyecto.challenge.model.mercado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearMercadoDTO {

    private String codigo;
    private String descripcion;
    private Long idPais;
}
