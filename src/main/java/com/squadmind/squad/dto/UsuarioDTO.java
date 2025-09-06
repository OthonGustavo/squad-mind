package com.squadmind.squad.dto;

import com.squadmind.squad.enums.UsuarioTipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private UsuarioTipo tipo;
    private String registro;
    private String criadoEm;
    private String atualizado_em;
}
