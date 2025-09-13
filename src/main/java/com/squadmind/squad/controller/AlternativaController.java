package com.squadmind.squad.controller;

import com.squadmind.squad.dto.AlternativaDTO;
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

    // --- Criar alternativa para uma pergunta ---
    @PostMapping("/pergunta/{perguntaId}")
    public ResponseEntity<AlternativaDTO> criarAlternativa(
            @PathVariable Long perguntaId,
            @RequestBody AlternativaDTO dto) {
        AlternativaDTO novaAlternativa = alternativaService.criarAlternativa(perguntaId, dto);
        return ResponseEntity.ok(novaAlternativa);
    }

    // --- Buscar alternativa por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<AlternativaDTO> buscarPorId(@PathVariable Long id) {
        AlternativaDTO alternativa = alternativaService.buscarPorId(id);
        return ResponseEntity.ok(alternativa);
    }

    // --- Listar todas as alternativas ---
    @GetMapping
    public ResponseEntity<List<AlternativaDTO>> listarTodas() {
        List<AlternativaDTO> alternativas = alternativaService.listarTodas();
        return ResponseEntity.ok(alternativas);
    }

    // --- Remover alternativa ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAlternativa(@PathVariable Long id) {
        alternativaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
