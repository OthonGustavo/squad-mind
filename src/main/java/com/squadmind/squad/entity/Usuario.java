package com.squadmind.squad.entity;

import com.squadmind.squad.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    @OneToMany(mappedBy = "professor")
    private List<Turmas> turmas = new ArrayList<>();

    @OneToMany(mappedBy = "alunos")
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<GrupoAlunos> grupoAlunos = new ArrayList<>();

    @OneToMany(mappedBy = "alunoId")
    private List<Respostas> respostas = new ArrayList<>();

    @ToString.Include
    @Getter @Setter
    private String nome;

    @ToString.Include
    @Getter @Setter
    private String email;

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
    @Column(name = "criado_em")
    @CreationTimestamp
    private Instant criadoEm;

    public Usuario(Long id, String nome, String email, String senha, String tipo, String registro, Instant criadoEm) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.registro = registro;
        this.criadoEm = criadoEm;
    }

    public String getCriadoEm() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return formatter.format(criadoEm);
    }

    public void setCriadoEm() {
        this.criadoEm = Instant.now();
    }

}
