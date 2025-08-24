package com.squadmind.squad.entity;

import com.squadmind.squad.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ToString.Include
    private Long id;

    @OneToMany(mappedBy = "professorId")
    private List<Turmas> turmas = new ArrayList<>();

    @OneToMany(mappedBy = "alunoId")
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @OneToMany
    private List<GrupoAlunos> grupoAlunos = new ArrayList<>();

    @OneToMany
    private List<Respostas> respostas = new ArrayList<>();

    @ToString.Include
    @Getter @Setter
    private String nome;

    @ToString.Include
    @Getter @Setter
    private String senha;

    @Getter @Setter
    @ToString.Include
    private String tipo;

    @ToString.Include
    @Getter @Setter
    private String registro;

    @ToString.Include
    @Getter
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
