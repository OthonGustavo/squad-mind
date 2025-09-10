package com.squadmind.squad.controller;

import com.squadmind.squad.entity.Grupo;
import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping("/projeto/{projetoId}")
    public ResponseEntity<Grupo> criarGrupo(@PathVariable Long projetoId, @RequestBody Grupo grupo) {
        Grupo novoGrupo = grupoService.criarGrupo(projetoId, grupo);
        return ResponseEntity.ok(novoGrupo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarPorId(@PathVariable Long id) {
        Grupo grupo = grupoService.buscarPorId(id);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> listarTodos() {
        List<Grupo> grupos = grupoService.listarTodos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}/membros")
    public ResponseEntity<List<GrupoMembros>> listarMembrosDoGrupo(@PathVariable Long id) {
        List<GrupoMembros> membros = grupoService.listarMembrosDoGrupo(id);
        return ResponseEntity.ok(membros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerGrupo(@PathVariable Long id) {
        grupoService.removerGrupo(id);
        return ResponseEntity.noContent().build();
    }
}