package com.squadmind.squad.controller;

import com.squadmind.squad.dto.RespostaDTO;
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
    public ResponseEntity<RespostaDTO> salvarResposta(
            @PathVariable Long usuarioId,
            @PathVariable Long projetoId,
            @PathVariable Long perguntaId,
            @RequestParam(required = false) Long alternativaId,
            @RequestBody RespostaDTO dto) {

        RespostaDTO novaResposta = respostaService.salvarResposta(usuarioId, projetoId, perguntaId, alternativaId, dto);
        return ResponseEntity.ok(novaResposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDTO> buscarPorId(@PathVariable Long id) {
        RespostaDTO resposta = respostaService.buscarPorId(id);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RespostaDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<RespostaDTO> respostas = respostaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<RespostaDTO>> listarPorProjeto(@PathVariable Long projetoId) {
        List<RespostaDTO> respostas = respostaService.listarPorProjeto(projetoId);
        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/pergunta/{perguntaId}")
    public ResponseEntity<List<RespostaDTO>> listarPorPergunta(@PathVariable Long perguntaId) {
        List<RespostaDTO> respostas = respostaService.listarPorPergunta(perguntaId);
        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/alternativa/{alternativaId}")
    public ResponseEntity<List<RespostaDTO>> listarPorAlternativa(@PathVariable Long alternativaId) {
        List<RespostaDTO> respostas = respostaService.listarPorAlternativa(alternativaId);
        return ResponseEntity.ok(respostas);
    }

    @GetMapping
    public ResponseEntity<List<RespostaDTO>> listarTodas() {
        List<RespostaDTO> respostas = respostaService.listarTodas();
        return ResponseEntity.ok(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerResposta(@PathVariable Long id) {
        respostaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
