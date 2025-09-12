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

    private Long id;
    private String nome;
    private String tipo;
    private UsuarioDTO mediador;
    private ProjetoDTO projeto;
    private Instant criadoEm;

    // Construtor que converte entidade em DTO
    public QuestionarioDTO(Questionario questionario) {
        if (questionario != null) {
            this.id = questionario.getId();
            this.nome = questionario.getNome();
            this.tipo = questionario.getTipo();
            this.criadoEm = questionario.getCriadoEm();

            if (questionario.getMediador() != null) {
                this.mediador = new UsuarioDTO(questionario.getMediador());
            }

            if (questionario.getProjeto() != null) {
                this.projeto = new ProjetoDTO(questionario.getProjeto());
            }
        }
    }
}
