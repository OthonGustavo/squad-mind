package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GrupoAlunosDTO;
import com.squadmind.squad.service.GrupoAlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma-alunos")
public class TurmaAlunoController {

    @Autowired
    private GrupoAlunosService grupoAlunosService;

    // Criar associação aluno → grupo
    @PostMapping
    public GrupoAlunosDTO criarGrupoAluno(@RequestBody GrupoAlunosDTO input) {
        return grupoAlunosService.criarGrupoAluno(
                input.getAlunoId(),
                input.getGrupoId(),
                input.getRegistroAluno()
        );
    }

    // Buscar registro por ID
    @GetMapping("/{id}")
    public GrupoAlunosDTO buscarGrupoAluno(@PathVariable Long id) {
        return grupoAlunosService.buscarGrupoAluno(id);
    }

    // Listar todos os registros
    @GetMapping
    public List<GrupoAlunosDTO> listarGrupoAlunos() {
        return grupoAlunosService.listarGrupoAlunos();
    }

    // Deletar registro
    @DeleteMapping("/{id}")
    public void deletarGrupoAluno(@PathVariable Long id) {
        grupoAlunosService.deletarGrupoAluno(id);
    }
}
