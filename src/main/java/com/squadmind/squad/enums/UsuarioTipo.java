package com.squadmind.squad.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UsuarioTipo {

    ALUNO("aluno"),
    PROFESSOR("professor");

    private final String code;

   UsuarioTipo(String code) {
        this.code = code;
   }

   @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static UsuarioTipo fromValue(UsuarioTipo value) {
        for (UsuarioTipo tipo : values()) {
            if (tipo.code.equals(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + value);
    }

}
