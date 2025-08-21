package com.squadmind.squad.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turmas")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString
public class Turmas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "nome_turma")
    private String nomeTurma;

    @Column(name = "chave_entrada")
    private String chaveEntrada;

    @OneToMany
    @JoinColumn(name = "professor_id")
    private List<Usuario> professorId = new ArrayList<>();

    private List<Usuario> alunoId = new ArrayList<>();

    @Column(name = "criado_em")
    private Instant criadoEm;

}
