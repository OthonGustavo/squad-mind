package com.squadmind.squad.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turma_alunos")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class TurmaAluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private List<Usuario> alunoId = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private List<Turmas> turmaId = new ArrayList<>();

    @Column(name = "data_entrada")
    private Instant dataEntrada;

    public TurmaAluno(Long id, Instant dataEntrada) {
        this.id = id;
        this.dataEntrada = dataEntrada;
    }
}
