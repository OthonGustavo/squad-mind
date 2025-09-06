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
@Table(name = "questionario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Questionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String tipo;

    @ManyToOne
    @JoinColumn(name="mediador_id")
    private Usuario mediador_id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projetos = new ArrayList<>();

    @OneToMany(mappedBy = "questionario_id")
    @ToString.Exclude
    private List<PerfilResultado> perfilResultados = new ArrayList<>();

    @OneToMany(mappedBy = "questionario_id")
    @ToString.Exclude
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "questionario_id")
    @ToString.Exclude
    private List<Pergunta> perguntas = new ArrayList<>();

    @CreationTimestamp
    private Instant criado_em;

    public Questionario(int id, String nome, String tipo, Instant criado_em) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.criado_em = criado_em;
    }

}

