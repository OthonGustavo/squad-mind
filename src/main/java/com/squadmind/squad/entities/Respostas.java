package com.squadmind.squad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Respostas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String respostas_json;
    private List<Usuario> alunoId = new ArrayList<>();
    private List<Turmas> turmasId = new ArrayList<>();

    @Getter
    private Integer pontuacaoD;

    @Getter
    private Integer pontuacaoI;

    @Getter
    private Integer pontuacaoS;

    @Getter
    private Integer pontuacaoC;

    @Getter
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
