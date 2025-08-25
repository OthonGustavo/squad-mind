package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GrupoAlunosDTO;
import com.squadmind.squad.service.GrupoAlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-alunos")
public class GrupoAlunosController {

    @Autowired
    private GrupoAlunosService grupoAlunosService;

    @PostMapping
    public GrupoAlunosDTO criarGrupoAluno(@RequestParam Long alunoId,
                                          @RequestParam Long grupoId,
                                          @RequestParam String registroAluno) {
        return grupoAlunosService.criarGrupoAluno(alunoId, grupoId, registroAluno);
    }

    @GetMapping("/{id}")
    public GrupoAlunosDTO buscarGrupoAluno(@PathVariable Long id) {
        return grupoAlunosService.buscarGrupoAluno(id);
    }

    @GetMapping
    public List<GrupoAlunosDTO> listarGrupoAlunos() {
        return grupoAlunosService.listarGrupoAlunos();
    }

    @DeleteMapping("/{id}")
    public void deletarGrupoAluno(@PathVariable Long id) {
        grupoAlunosService.deletarGrupoAluno(id);
    }
}
