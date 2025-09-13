package com.squadmind.squad.mapper;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.Usuario;

public class UsuarioMapper {

    // Converte uma entidade Usuario em DTO
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario);
    }

    public static Usuario toEntity(UsuarioDTO usuarioDTO){
        if (usuarioDTO == null) return null;
        Usuario usuario = new Usuario();
        usuario.setId(usuario.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuario;
    }
}
