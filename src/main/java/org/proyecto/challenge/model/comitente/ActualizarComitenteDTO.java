package org.proyecto.challenge.model.comitente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarComitenteDTO {

    private Long idComitente;
    private String descripcion;
    private Set<Long> idMercados;
}