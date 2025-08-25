package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GruposDTO;
import com.squadmind.squad.dto.TurmasDTO;
import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.service.TurmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmasController {

    @Autowired
    private TurmasService turmasService;

    @PostMapping
    public TurmasDTO criarTurma(@RequestBody Turmas turma) {
        return turmasService.criarTurma(turma);
    }

    @GetMapping("/{id}")
    public TurmasDTO buscarTurma(@PathVariable Long id) {
        return turmasService.buscarTurma(id);
    }

    @GetMapping
    public List<TurmasDTO> listarTurmas() {
        return turmasService.listarTurmas();
    }

    @PutMapping("/{id}")
    public TurmasDTO atualizarTurma(@PathVariable Long id, @RequestBody Turmas turmaAtualizada) {
        return turmasService.atualizarTurma(id, turmaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable Long id) {
        turmasService.deletarTurma(id);
    }

    @PostMapping("/{turmaId}/grupos")
    public TurmasDTO criarGrupo(@PathVariable Long turmaId, @RequestBody Grupos grupo) {
        return turmasService.criarGrupo(turmaId, grupo);
    }

    @GetMapping("/{turmaId}/grupos")
    public List<GruposDTO> listarGruposPorTurma(@PathVariable Long turmaId) {
        return turmasService.listarGruposPorTurma(turmaId);
    }
}
