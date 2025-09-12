package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Participante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteDTO {

    private Long id;
    private UsuarioDTO usuario;
    private ProjetoDTO projeto;
    private Instant dataEntrada;

    // Construtor que converte entidade em DTO
    public ParticipanteDTO(Participante participante) {
        if (participante != null) {
            this.id = participante.getId();
            this.dataEntrada = participante.getDataEntrada();

            if (participante.getUsuario() != null) {
                this.usuario = new UsuarioDTO(participante.getUsuario());
            }

            if (participante.getProjeto() != null) {
                this.projeto = new ProjetoDTO(participante.getProjeto());
            }
        }
    }
}
