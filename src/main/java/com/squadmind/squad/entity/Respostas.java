package com.squadmind.squad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "respostas_disc")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Respostas implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @ToString.Include
    private Long id;

    @Getter
    @Column(name = "respostas_json")
    private String respostas_json;

    @Getter
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario alunoId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turmas turmasId;

    @ToString.Include
    @Getter
    @Column(name = "pontuacao_d")
    private Integer pontuacaoD;

    @ToString.Include
    @Getter
    @Column(name = "pontuacao_i")
    private Integer pontuacaoI;

    @ToString.Include
    @Getter
    @Column(name = "pontuacao_s")
    private Integer pontuacaoS;

    @ToString.Include
    @Getter
    @Column(name = "pontuacao_c")
    private Integer pontuacaoC;

    @ToString.Include
    @Getter
    @Column(name = "perfil_dominante")
    private String perfilDominante;

    public Respostas(Integer pontuacaoD, Integer pontuacaoI, Integer pontuacaoS, Integer pontuacaoC, String perfilDominante, String respostas_json, Long id) {
        this.pontuacaoD = pontuacaoD;
        this.pontuacaoI = pontuacaoI;
        this.pontuacaoS = pontuacaoS;
        this.pontuacaoC = pontuacaoC;
        this.perfilDominante = perfilDominante;
        this.respostas_json = respostas_json;
        this.id = id;
    }

}
