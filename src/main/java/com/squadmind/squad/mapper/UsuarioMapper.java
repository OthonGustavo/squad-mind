package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.Usuario;

public class UsuarioMapper {

    // Converte uma entidade Usuario em DTO
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario);
    }
}
