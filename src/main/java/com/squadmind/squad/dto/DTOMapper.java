package com.squadmind.squad.dto;

import com.squadmind.squad.entity.*;
import com.squadmind.squad.enums.UsuarioTipo;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DTOMapper {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return new UsuarioDTO(
        );
    }

}
