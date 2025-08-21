package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupo_alunos")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class GrupoAlunos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private List<Usuario> alunoId = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private List<Grupos> grupos = new ArrayList<>();

    @Column(name = "registro_aluno")
    private List<Usuario> registroAluno = new ArrayList<>();

}
