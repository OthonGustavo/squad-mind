package com.squadmind.squad.controller;

import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.service.GrupoMembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-membros")
public class GrupoMembrosController {

    @Autowired
    private GrupoMembrosService grupoMembrosService;

    // --- Adicionar membro ao grupo ---
    @PostMapping("/grupo/{grupoId}/usuario/{usuarioId}")
    public ResponseEntity<GrupoMembrosDTO> adicionarMembro(
            @PathVariable Long grupoId,
            @PathVariable Long usuarioId,
            @RequestParam(defaultValue = "false") Boolean lider) {

        GrupoMembrosDTO novoMembro = grupoMembrosService.adicionarMembro(grupoId, usuarioId, lider);
        return ResponseEntity.ok(novoMembro);
    }

    // --- Buscar membro por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<GrupoMembrosDTO> buscarPorId(@PathVariable Long id) {
        GrupoMembrosDTO membro = grupoMembrosService.buscarPorId(id);
        return ResponseEntity.ok(membro);
    }

    // --- Listar todos os membros ---
    @GetMapping
    public ResponseEntity<List<GrupoMembrosDTO>> listarTodos() {
        List<GrupoMembrosDTO> membros = grupoMembrosService.listarTodos();
        return ResponseEntity.ok(membros);
    }

    // --- Remover membro ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMembro(@PathVariable Long id) {
        grupoMembrosService.removerMembro(id);
        return ResponseEntity.noContent().build();
    }
}
