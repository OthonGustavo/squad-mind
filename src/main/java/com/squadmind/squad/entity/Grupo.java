package com.squadmind.squad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
public class Grupo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @JsonIgnore
    private Projeto projeto;

    @ToString.Include
    @Column(name = "numero_grupo")
    private Integer numero_grupo;

    @ToString.Include
    private String criterio_formacao;

    @ToString.Include
    @CreationTimestamp
    private Instant criado_em;

    public Grupo(Long id, Integer numero_grupo) {
        this.id = id;
        this.numero_grupo = numero_grupo;
    }

}
