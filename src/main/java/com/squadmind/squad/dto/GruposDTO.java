package com.squadmind.squad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GruposDTO {
    private Long id;
    private Integer numeroGrupo;
    private Long turmaId; // Apenas o ID da turma
}
