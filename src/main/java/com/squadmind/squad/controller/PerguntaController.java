package com.squadmind.squad.controller;

import com.squadmind.squad.dto.PerguntaDTO;
import com.squadmind.squad.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    // --- Criar pergunta ---
    @PostMapping("/questionario/{questionarioId}/tag/{tagId}")
    public ResponseEntity<PerguntaDTO> criarPergunta(
            @PathVariable Long questionarioId,
            @PathVariable Long tagId,
            @RequestBody PerguntaDTO dto) {

        PerguntaDTO novaPergunta = perguntaService.criarPergunta(questionarioId, tagId, dto);
        return ResponseEntity.ok(novaPergunta);
    }

    // --- Listar perguntas por questionário ---
    @GetMapping("/questionario/{questionarioId}")
    public ResponseEntity<List<PerguntaDTO>> listarPerguntasPorQuestionario(@PathVariable Long questionarioId) {
        List<PerguntaDTO> perguntas = perguntaService.listarPerguntasPorQuestionario(questionarioId);
        return ResponseEntity.ok(perguntas);
    }

    // --- Buscar pergunta por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<PerguntaDTO> buscarPorId(@PathVariable Long id) {
        PerguntaDTO pergunta = perguntaService.buscarPorId(id);
        return ResponseEntity.ok(pergunta);
    }

    // --- Listar todas as perguntas ---
    @GetMapping
    public ResponseEntity<List<PerguntaDTO>> listarTodas() {
        List<PerguntaDTO> perguntas = perguntaService.listarTodas();
        return ResponseEntity.ok(perguntas);
    }

    // --- Remover pergunta ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPergunta(@PathVariable Long id) {
        perguntaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
