package com.squadmind.squad.enums;

public enum UsuarioTipo {

    ALUNO("Aluno"),
    PROFESSOR("Professor");

    private String code;

   UsuarioTipo(String code) {
        this.code = code;
   }

   public String getCode(){
       return code;
    }

}
