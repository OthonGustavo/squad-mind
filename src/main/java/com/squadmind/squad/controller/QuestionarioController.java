package com.squadmind.squad.controller;

import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.dto.QuestionarioDTO;
import com.squadmind.squad.mapper.PerfilResultadoMapper;
import com.squadmind.squad.service.QuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/questionarios")
public class QuestionarioController {

    @Autowired
    private QuestionarioService questionarioService;

    @PostMapping("/projeto/{projetoId}")
    public ResponseEntity<QuestionarioDTO> criarQuestionario(@PathVariable Long projetoId,
                                                             @RequestBody QuestionarioDTO dto) {
        QuestionarioDTO novoQuestionario = questionarioService.criarQuestionario(projetoId, dto);
        return ResponseEntity.ok(novoQuestionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionarioDTO> buscarPorId(@PathVariable Long id) {
        QuestionarioDTO questionario = questionarioService.buscarPorId(id);
        return ResponseEntity.ok(questionario);
    }

    @GetMapping
    public ResponseEntity<List<QuestionarioDTO>> listarTodos() {
        List<QuestionarioDTO> questionariosDTO = questionarioService.listarTodos();
        return ResponseEntity.ok(questionariosDTO);
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultadoDTO>> listarResultadosQuestionario(@PathVariable Long id) {
        List<PerfilResultadoDTO> resultadosDTO = questionarioService.listarResultadosQuestionario(id);
        return ResponseEntity.ok(resultadosDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerQuestionario(@PathVariable Long id) {
        questionarioService.removerQuestionario(id);
        return ResponseEntity.noContent().build();
    }
}
