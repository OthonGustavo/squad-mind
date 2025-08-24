package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupo_alunos")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class GrupoAlunos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ToString.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupos grupo_alunos;

    @Column(name = "registro_aluno")
    private Usuario registroAluno;

}
