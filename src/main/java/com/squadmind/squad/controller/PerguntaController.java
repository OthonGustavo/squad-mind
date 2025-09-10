package com.squadmind.squad.controller;

import com.squadmind.squad.entity.Pergunta;
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

    @PostMapping("/questionario/{questionarioId}/tag/{tagId}")
    public ResponseEntity<Pergunta> criarPergunta(
            @PathVariable Long questionarioId,
            @PathVariable Long tagId,
            @RequestBody Pergunta pergunta) {
        Pergunta novaPergunta = perguntaService.criarPergunta(questionarioId, tagId, pergunta);
        return ResponseEntity.ok(novaPergunta);
    }

    @GetMapping("/questionario/{questionarioId}")
    public ResponseEntity<List<Pergunta>> listarPerguntasPorQuestionario(@PathVariable Long questionarioId) {
        List<Pergunta> perguntas = perguntaService.listarPerguntasPorQuestionario(questionarioId);
        return ResponseEntity.ok(perguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pergunta> buscarPorId(@PathVariable Long id) {
        Pergunta pergunta = perguntaService.buscarPorId(id);
        return ResponseEntity.ok(pergunta);
    }

    @GetMapping
    public ResponseEntity<List<Pergunta>> listarTodas() {
        List<Pergunta> perguntas = perguntaService.listarTodas();
        return ResponseEntity.ok(perguntas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPergunta(@PathVariable Long id) {
        perguntaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}