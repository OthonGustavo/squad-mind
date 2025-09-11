package com.squadmind.squad.entity;

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
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Grupo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeGrupo;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    private Integer numeroGrupo;

    private String criterioFormacao;

    @CreationTimestamp
    private Instant criadoEm;

    @OneToMany(mappedBy = "grupo")
    private List<GrupoMembros> grupoMembros = new ArrayList<>();
}
