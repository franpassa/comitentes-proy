package org.proyecto.challenge.model.mercado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.proyecto.challenge.model.pais.Pais;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;
}