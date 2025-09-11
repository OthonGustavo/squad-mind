package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Questionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionarioDTO {

    private int id;
    private String nome;
    private String tipo;
    private UsuarioDTO mediador;
    private ProjetoDTO projeto;
    private Instant criadoEm;

    public QuestionarioDTO(Questionario questionario) {
        this.id = questionario.getId();
        this.nome = questionario.getNome();
        this.tipo = questionario.getTipo();
        if (questionario.getMediador() != null) {
            this.mediador = new UsuarioDTO(questionario.getMediador());
        }
        if(questionario.getProjeto() != null) {
            this.projeto = new ProjetoDTO(questionario.getProjeto());
        }
        this.criadoEm = questionario.getCriadoEm();
    }
}