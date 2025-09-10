package com.squadmind.squad.controller;

import com.squadmind.squad.entity.Alternativa;
import com.squadmind.squad.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alternativas")
public class AlternativaController {

    @Autowired
    private AlternativaService alternativaService;

    @PostMapping("/pergunta/{perguntaId}")
    public ResponseEntity<Alternativa> criarAlternativa(@PathVariable Long perguntaId, @RequestBody Alternativa alternativa) {
        Alternativa novaAlternativa = alternativaService.criarAlternativa(perguntaId, alternativa);
        return ResponseEntity.ok(novaAlternativa);
    }

    @GetMapping("/pergunta/{perguntaId}")
    public ResponseEntity<List<Alternativa>> listarAlternativasPorPergunta(@PathVariable Long perguntaId) {
        List<Alternativa> alternativas = alternativaService.listarAlternativasPorPergunta(perguntaId);
        return ResponseEntity.ok(alternativas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> buscarPorId(@PathVariable Long id) {
        Alternativa alternativa = alternativaService.buscarPorId(id);
        return ResponseEntity.ok(alternativa);
    }

    @GetMapping
    public ResponseEntity<List<Alternativa>> listarTodas() {
        List<Alternativa> alternativas = alternativaService.listarTodas();
        return ResponseEntity.ok(alternativas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAlternativa(@PathVariable Long id) {
        alternativaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}