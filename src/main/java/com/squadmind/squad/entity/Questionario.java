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
@Table(name = "TB_QUESTIONARIO")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Questionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    private Instant criado_em;

    @ManyToOne
    @JoinColumn(name = "mediador_id")
    private Usuario mediador;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @OneToMany(mappedBy = "questionario")
    private List<PerfilResultado> perfilResultados = new ArrayList<>();

    @OneToMany(mappedBy = "questionario")
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "questionario")
    private List<Pergunta> perguntas = new ArrayList<>();

    @ManyToMany(mappedBy = "questionario")
    private List<ProjetoQuestionario> projetoQuestionario = new ArrayList<>();

    @CreationTimestamp
    private Instant criadoEm;
}
