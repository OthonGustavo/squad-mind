package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToMany(mappedBy = "usuarios")
    private List<Turmas> turmas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarios")
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @OneToMany
    private List<GrupoAlunos> grupoAlunos = new ArrayList<>();

    @OneToMany
    private List<Respostas> respostas = new ArrayList<>();

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String senha;

    @Getter @Setter
    private String tipo;

    @Getter @Setter
    private String registro;

    @Getter @Setter
    @Column(name = "criado_em")
    private Instant criadoEm;

    public Usuario(Long id, String nome, String senha, String tipo, String registro, Instant criadoEm) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.registro = registro;
        this.criadoEm = criadoEm;
    }

}
