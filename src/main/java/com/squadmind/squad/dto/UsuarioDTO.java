package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.enums.UsuarioTipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private int id;
    private String nome;
    private String email;
    private UsuarioTipo tipo;
    private String registro;
    private String criadoEm;
    private String atualizado_em;

    public UsuarioDTO(Usuario usuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.tipo = usuario.getTipo();
        this.registro = usuario.getRegistro();
        this.criadoEm = formatter.format(usuario.getCriadoEm());
        this.atualizado_em = formatter.format(usuario.getAlteradoEm());
    }
}