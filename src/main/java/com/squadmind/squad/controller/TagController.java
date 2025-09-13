package com.squadmind.squad.controller;

import com.squadmind.squad.dto.TagDTO;
import com.squadmind.squad.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    // --- Criar tag em um questionário ---
    @PostMapping("/questionario/{questionarioId}")
    public ResponseEntity<TagDTO> criarTag(
            @PathVariable Long questionarioId,
            @RequestBody TagDTO dto) {
        TagDTO novaTag = tagService.criarTag(questionarioId, dto);
        return ResponseEntity.ok(novaTag);
    }

    // --- Listar todas as tags ---
    @GetMapping
    public ResponseEntity<List<TagDTO>> listarTodas() {
        List<TagDTO> tags = tagService.listarTodas();
        return ResponseEntity.ok(tags);
    }

    // --- Listar tags por questionário ---
    @GetMapping("/questionario/{questionarioId}")
    public ResponseEntity<List<TagDTO>> listarTagsPorQuestionario(
            @PathVariable Long questionarioId) {
        List<TagDTO> tags = tagService.listarTagsPorQuestionario(questionarioId);
        return ResponseEntity.ok(tags);
    }

    // --- Buscar tag por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> buscarPorId(@PathVariable Long id) {
        TagDTO tag = tagService.buscarPorId(id);
        return ResponseEntity.ok(tag);
    }

    // --- Remover tag ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        tagService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
