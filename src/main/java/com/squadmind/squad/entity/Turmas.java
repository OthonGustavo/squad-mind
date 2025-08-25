package com.squadmind.squad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "turmas")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Turmas implements Serializable {
    @Serial
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
    @Getter @Setter
    private String chaveEntrada;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    @Getter @Setter
    private Usuario professor;

    @OneToMany(mappedBy = "turmas")
    @JsonIgnore
    private List<TurmaAluno> turmaAlunos = new ArrayList<>();

    @OneToMany(mappedBy = "turmas")
    @JsonIgnore
    private List<Grupos> grupos = new ArrayList<>();

    @ToString.Include
    @Getter
    @CreationTimestamp
    @Column(name = "criado_em")
    private Instant criadoEm;

    public Turmas(Instant criadoEm, String nomeTurma, Long id, String chaveEntrada) {
        this.criadoEm = criadoEm;
        this.nomeTurma = nomeTurma;
        this.id = id;
        this.chaveEntrada = chaveEntrada;
    }

    public void setCriadoEm() {
        this.criadoEm = Instant.now();
    }

}
