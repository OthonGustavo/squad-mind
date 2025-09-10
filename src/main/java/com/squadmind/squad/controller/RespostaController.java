package com.squadmind.squad.controller;

import com.squadmind.squad.entity.Resposta;
import com.squadmind.squad.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping("/usuario/{usuarioId}/projeto/{projetoId}/pergunta/{perguntaId}")
    public ResponseEntity<Resposta> salvarResposta(
            @PathVariable Long usuarioId,
            @PathVariable Long projetoId,
            @PathVariable Long perguntaId,
            @RequestParam(required = false) Long alternativaId,
            @RequestBody Resposta resposta) {
        Resposta novaResposta = respostaService.salvarResposta(usuarioId, projetoId, perguntaId, alternativaId, resposta);
        return ResponseEntity.ok(novaResposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> buscarPorId(@PathVariable Long id) {
        Resposta resposta = respostaService.buscarPorId(id);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Resposta>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Resposta> respostas = respostaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(respostas);
    }

    @GetMapping
    public ResponseEntity<List<Resposta>> listarTodas() {
        List<Resposta> respostas = respostaService.listarTodas();
        return ResponseEntity.ok(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerResposta(@PathVariable Long id) {
        respostaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}