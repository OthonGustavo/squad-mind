package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @ToString.Include
    private Long id;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario usuarioId;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupos grupo_alunos;

    @ToString.Include
    @Column(name = "registro_aluno")
    private List<Usuario> registroAluno = new ArrayList<>();

}
