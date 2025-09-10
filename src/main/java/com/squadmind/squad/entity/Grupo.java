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
@Table(name = "TB_GRUPO")
@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
@ToString
public class Grupo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_grupo;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @Column(name = "numero_grupo")
    private Integer numero_grupo;

    @ToString.Include
    private String criterio_formacao;

    @CreationTimestamp
    private Instant criado_em;

    @OneToMany(mappedBy = "grupo_id")
    private List<GrupoMembros> grupoMembros = new ArrayList<>();

    public Grupo(Long id, String nome_grupo, Integer numero_grupo, String criterio_formacao, Instant criado_em) {
        this.id = id;
        this.nome_grupo = nome_grupo;
        this.numero_grupo = numero_grupo;
        this.criterio_formacao = criterio_formacao;
        this.criado_em = criado_em;
    }

}
