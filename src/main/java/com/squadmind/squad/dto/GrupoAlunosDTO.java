package com.squadmind.squad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrupoAlunosDTO {
    private Long id;
    private Long alunoId;
    private Long grupoId;
    private String registroAluno;
}
