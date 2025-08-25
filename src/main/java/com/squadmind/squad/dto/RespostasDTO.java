package com.squadmind.squad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostasDTO {
    private Long id;
    private Long alunoId;
    private Long turmaId;
    private Integer pontuacaoD;
    private Integer pontuacaoI;
    private Integer pontuacaoS;
    private Integer pontuacaoC;
    private String perfilDominante;
    private String respostasJson;
}
