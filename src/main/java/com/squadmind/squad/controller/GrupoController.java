package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GrupoDTO;
import com.squadmind.squad.dto.GrupoMembrosDTO;
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

    // --- Criar grupo dentro de um projeto ---
    @PostMapping("/projeto/{projetoId}")
    public ResponseEntity<GrupoDTO> criarGrupo(@PathVariable Long projetoId, @RequestBody GrupoDTO dto) {
        GrupoDTO novoGrupo = grupoService.criarGrupo(projetoId, dto);
        return ResponseEntity.ok(novoGrupo);
    }

    // --- Buscar grupo por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> buscarPorId(@PathVariable Long id) {
        GrupoDTO grupo = grupoService.buscarPorId(id);
        return ResponseEntity.ok(grupo);
    }

    // --- Listar todos os grupos ---
    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listarTodos() {
        List<GrupoDTO> grupos = grupoService.listarTodos();
        return ResponseEntity.ok(grupos);
    }

    // --- Listar membros de um grupo ---
    @GetMapping("/{id}/membros")
    public ResponseEntity<List<GrupoMembrosDTO>> listarMembrosDoGrupo(@PathVariable Long id) {
        List<GrupoMembrosDTO> membros = grupoService.listarMembrosDoGrupo(id);
        return ResponseEntity.ok(membros);
    }

    // --- Remover grupo ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerGrupo(@PathVariable Long id) {
        grupoService.removerGrupo(id);
        return ResponseEntity.noContent().build();
    }
}
