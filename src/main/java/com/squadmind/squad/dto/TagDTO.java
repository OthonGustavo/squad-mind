package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {

    private Long id;
    private String nomeTag;
    private String sigla;
    private QuestionarioDTO questionario;

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.nomeTag = tag.getNomeTag();
        this.sigla = tag.getSigla();

        if (tag.getQuestionario() != null) {
            this.questionario = new QuestionarioDTO(tag.getQuestionario());
        }
    }
}
