package org.proyecto.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comitente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "comitente_mercado",
            joinColumns = @JoinColumn(name = "comitente_id"),
            inverseJoinColumns = @JoinColumn(name = "mercado_id")
    )
    private Set<Mercado> mercados;
}
