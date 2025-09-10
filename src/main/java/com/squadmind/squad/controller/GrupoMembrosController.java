package com.squadmind.squad.controller;

import com.squadmind.squad.entity.GrupoMembros;
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

    @PostMapping("/grupo/{grupoId}/usuario/{usuarioId}")
    public ResponseEntity<GrupoMembros> adicionarMembro(
            @PathVariable Long grupoId,
            @PathVariable Long usuarioId,
            @RequestParam(defaultValue = "false") Boolean lider) {
        GrupoMembros novoMembro = grupoMembrosService.adicionarMembro(grupoId, usuarioId, lider);
        return ResponseEntity.ok(novoMembro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoMembros> buscarPorId(@PathVariable Long id) {
        GrupoMembros membro = grupoMembrosService.buscarPorId(id);
        return ResponseEntity.ok(membro);
    }

    @GetMapping
    public ResponseEntity<List<GrupoMembros>> listarTodos() {
        List<GrupoMembros> membros = grupoMembrosService.listarTodos();
        return ResponseEntity.ok(membros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMembro(@PathVariable Long id) {
        grupoMembrosService.removerMembro(id);
        return ResponseEntity.noContent().build();
    }
}