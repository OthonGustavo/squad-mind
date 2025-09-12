package com.squadmind.squad.dto;

import com.squadmind.squad.entity.ProjetoQuestionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoQuestionarioDTO {

    private Long id;
    private List<ProjetoDTO> projetos;
    private List<QuestionarioDTO> questionarios;

    // Construtor que converte entidade em DTO
    public ProjetoQuestionarioDTO(ProjetoQuestionario projetoQuestionario) {
        if (projetoQuestionario != null) {
            this.id = projetoQuestionario.getId();

            if (projetoQuestionario.getProjeto() != null && !projetoQuestionario.getProjeto().isEmpty()) {
                this.projetos = projetoQuestionario.getProjeto().stream()
                        .map(ProjetoDTO::new)
                        .collect(Collectors.toList());
            }

            if (projetoQuestionario.getQuestionario() != null && !projetoQuestionario.getQuestionario().isEmpty()) {
                this.questionarios = projetoQuestionario.getQuestionario().stream()
                        .map(QuestionarioDTO::new)
                        .collect(Collectors.toList());
            }
        }
    }
}
