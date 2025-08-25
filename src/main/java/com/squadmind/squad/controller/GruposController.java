package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GruposDTO;
import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.service.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GruposController {

    @Autowired
    private GruposService gruposService;

    @PostMapping("/{turmaId}")
    public GruposDTO criarGrupo(@PathVariable Long turmaId, @RequestBody Grupos grupo) {
        return gruposService.criarGrupo(turmaId, grupo);
    }

    @GetMapping("/{id}")
    public GruposDTO buscarGrupo(@PathVariable Long id) {
        return gruposService.buscarGrupo(id);
    }

    @GetMapping
    public List<GruposDTO> listarGrupos() {
        return gruposService.listarGrupos();
    }

    @PutMapping("/{id}")
    public GruposDTO atualizarGrupo(@PathVariable Long id, @RequestBody Grupos grupoAtualizado) {
        return gruposService.atualizarGrupo(id, grupoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarGrupo(@PathVariable Long id) {
        gruposService.deletarGrupo(id);
    }

    @GetMapping("/turma/{turmaId}")
    public List<GruposDTO> listarGruposPorTurma(@PathVariable Long turmaId) {
        return gruposService.listarGruposPorTurma(turmaId);
    }
}
