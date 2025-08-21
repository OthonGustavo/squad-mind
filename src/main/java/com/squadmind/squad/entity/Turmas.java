package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @Getter @Setter
    private Usuario professorId;

    @OneToMany(mappedBy = "turmas")
    @Getter @Setter
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @Getter
    @Column(name = "criado_em")
    private Instant criadoEm;

}
