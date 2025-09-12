package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Pergunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerguntaDTO {

    private Long id;
    private String descricao;
    private String tipo;
    private TagDTO tag;
    private QuestionarioDTO questionario;

    public PerguntaDTO(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.descricao = pergunta.getDescricao();
        this.tipo = pergunta.getTipo();

        if (pergunta.getTag() != null) {
            this.tag = new TagDTO(pergunta.getTag());
        }
        if (pergunta.getQuestionario() != null) {
            this.questionario = new QuestionarioDTO(pergunta.getQuestionario());
        }
    }
}
