package com.squadmind.squad.dto;

import com.squadmind.squad.entity.Tipo;
import com.squadmind.squad.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private int id;
    private String nome;
    private String email;
    private String registro;
    private Instant criadoEm;
    private Instant alteradoEm;
    private List<TipoDTO> tipos = new ArrayList<>();

    public UsuarioDTO(Usuario usuario) {
        if (usuario != null) {
            this.id = usuario.getId();
            this.nome = usuario.getNome();
            this.email = usuario.getEmail();
            this.registro = usuario.getRegistro();
            this.criadoEm = usuario.getCriadoEm();
            this.alteradoEm = usuario.getAlteradoEm();

            if (usuario.getTipos() != null) {
                for (Tipo tipo : usuario.getTipos()) {
                    this.tipos.add(new TipoDTO(tipo));
                }
            }
        }
    }
}
