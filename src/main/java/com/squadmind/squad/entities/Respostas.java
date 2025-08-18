package com.squadmind.squad.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Respostas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String respostas_json;
    private List<Turmas> turmas = new ArrayList<>();
    private Integer pontuacaoD;
    private Integer pontuacaoI;
    private Integer pontuacaoS;
    private Integer pontuacaoC;
    private String perfilDominante;

}
