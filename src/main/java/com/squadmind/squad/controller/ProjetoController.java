package com.squadmind.squad.controller;

import com.squadmind.squad.dto.ProjetoDTO;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/coordenador/{coordenadorId}")
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody Projeto projeto, @PathVariable int coordenadorId) {
        return ResponseEntity.ok(projetoService.criarProjeto(projeto, coordenadorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> buscarProjeto(@PathVariable int id) {
        return ResponseEntity.ok(projetoService.buscarProjeto(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listarProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/coordenador/{coordenadorId}")
    public ResponseEntity<List<ProjetoDTO>> listarProjetosPorCoordenador(@PathVariable int coordenadorId) {
        return ResponseEntity.ok(projetoService.listarProjetosPorCoordenador(coordenadorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable int id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}