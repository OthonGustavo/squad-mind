package com.squadmind.squad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Turmas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ToString.Include
    private Long id;

    @Getter @Setter
    @ToString.Include
    @Column(name = "nome_turma")
    private String nomeTurma;

    @ToString.Include
    @Column(name = "chave_entrada")
    private String chaveEntrada;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "professor_id")
    @Getter @Setter
    private Usuario professorId;

    @ToString.Include
    @OneToMany(mappedBy = "turmas")
    @Getter @Setter
    @JsonIgnore
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @ToString.Include
    @Getter
    @Column(name = "criado_em")
    private Instant criadoEm;

}
