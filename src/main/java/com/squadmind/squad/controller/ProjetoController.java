package com.squadmind.squad.controller;

import com.squadmind.squad.dto.*;
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

    // --- Criar projeto ---
    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody ProjetoDTO dto) {
        ProjetoDTO novoProjeto = projetoService.criarProjeto(dto);
        return ResponseEntity.ok(novoProjeto);
    }

    // --- Buscar projeto por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> buscarPorId(@PathVariable Long id) {
        ProjetoDTO projeto = projetoService.buscarPorId(id);
        return ResponseEntity.ok(projeto);
    }

    // --- Listar todos os projetos ---
    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listarProjetos() {
        List<ProjetoDTO> projetosDTO = projetoService.listarProjetos();
        return ResponseEntity.ok(projetosDTO);
    }

    // --- Listar participantes do projeto ---
    @GetMapping("/{id}/participantes")
    public ResponseEntity<List<ParticipanteDTO>> listarParticipantes(@PathVariable Long id) {
        List<ParticipanteDTO> participantes = projetoService.listarParticipantes(id);
        return ResponseEntity.ok(participantes);
    }

    // --- Listar grupos do projeto ---
    @GetMapping("/{id}/grupos")
    public ResponseEntity<List<GrupoDTO>> listarGruposDoProjeto(@PathVariable Long id) {
        List<GrupoDTO> grupos = projetoService.listarGruposDoProjeto(id);
        return ResponseEntity.ok(grupos);
    }

    // --- Listar questionários do projeto ---
    @GetMapping("/{id}/questionarios")
    public ResponseEntity<List<QuestionarioDTO>> listarQuestionariosDoProjeto(@PathVariable Long id) {
        List<QuestionarioDTO> questionarios = projetoService.listarQuestionariosDoProjeto(id);
        return ResponseEntity.ok(questionarios);
    }

    // --- Listar resultados do projeto ---
    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultadoDTO>> listarResultadosProjeto(@PathVariable Long id) {
        List<PerfilResultadoDTO> resultados = projetoService.listarResultadosProjeto(id);
        return ResponseEntity.ok(resultados);
    }

    // --- Remover projeto ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProjeto(@PathVariable Long id) {
        projetoService.removerProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
