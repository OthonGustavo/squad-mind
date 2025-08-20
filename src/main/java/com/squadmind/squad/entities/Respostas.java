package com.squadmind.squad.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "respostas_disc")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Respostas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "respostas_json")
    private String respostas_json;

    @Column(name = "aluno_id")
    private List<Usuario> alunoId = new ArrayList<>();

    @Column(name = "turma_id")
    private List<Turmas> turmasId = new ArrayList<>();

    @Getter
    @Column(name = "pontuacao_d")
    private Integer pontuacaoD;

    @Getter
    @Column(name = "pontuacao_i")
    private Integer pontuacaoI;

    @Getter
    @Column(name = "pontuacao_s")
    private Integer pontuacaoS;

    @Getter
    @Column(name = "pontuacao_c")
    private Integer pontuacaoC;

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
