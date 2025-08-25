package com.squadmind.squad.dto;

import com.squadmind.squad.entity.*;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DTOMapper {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipo(),
                usuario.getRegistro(),
                formatter.format(usuario.getCriadoEm())
        );
    }

    public static TurmasDTO toTurmasDTO(Turmas turma) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return new TurmasDTO(
                turma.getId(),
                turma.getNomeTurma(),
                turma.getChaveEntrada(),
                turma.getProfessor().getId(),
                formatter.format(turma.getCriadoEm())
        );
    }

    public static GruposDTO toGruposDTO(Grupos grupo) {
        return new GruposDTO(
                grupo.getId(),
                grupo.getNumeroGrupo(),
                grupo.getTurmas().getId()
        );
    }

    public static GrupoAlunosDTO toGrupoAlunosDTO(GrupoAlunos grupoAluno) {
        return new GrupoAlunosDTO(
                grupoAluno.getId(),
                grupoAluno.getAluno().getId(),
                grupoAluno.getGrupo_alunos().getId(),
                grupoAluno.getRegistroAluno()
        );
    }

    public static RespostasDTO toRespostasDTO(Respostas respostas) {
        return new RespostasDTO(
                respostas.getId(),
                respostas.getAlunoId().getId(),
                respostas.getTurmasId().getId(),
                respostas.getPontuacaoD(),
                respostas.getPontuacaoI(),
                respostas.getPontuacaoS(),
                respostas.getPontuacaoC(),
                respostas.getPerfilDominante(),
                respostas.getRespostas_json()
        );
    }
}
