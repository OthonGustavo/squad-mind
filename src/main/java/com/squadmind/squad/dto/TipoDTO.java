package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDTO {

    private Long id;
    private String nomeTipo;

    public TipoDTO(Tipo tipo) {
        if (tipo != null) {
            this.id = tipo.getId();
            this.nomeTipo = tipo.getNome_tipo();
        }
    }
}
