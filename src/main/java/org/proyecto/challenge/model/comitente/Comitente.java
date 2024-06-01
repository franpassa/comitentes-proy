package org.proyecto.challenge.model.comitente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.proyecto.challenge.model.mercado.Mercado;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
