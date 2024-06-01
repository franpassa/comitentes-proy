package org.proyecto.challenge.model.comitente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearComitenteDTO {

    private String descripcion;
    private Set<Long> idMercados;
}