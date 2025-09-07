package com.squadmind.squad.controller;

import com.squadmind.squad.dto.QuestionarioDTO;
import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Questionario;
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
    public ResponseEntity<QuestionarioDTO> criarQuestionario(@PathVariable Long projetoId, @RequestBody Questionario questionario) {
        Questionario novoQuestionario = questionarioService.criarQuestionario(projetoId, questionario);
        return ResponseEntity.ok(new QuestionarioDTO(novoQuestionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionarioDTO> buscarPorId(@PathVariable Long id) {
        Questionario questionario = questionarioService.buscarPorId(id);
        return ResponseEntity.ok(new QuestionarioDTO(questionario));
    }

    @GetMapping
    public ResponseEntity<List<QuestionarioDTO>> listarTodos() {
        List<Questionario> questionarios = questionarioService.listarTodos();
        List<QuestionarioDTO> questionariosDTO = questionarios.stream().map(QuestionarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(questionariosDTO);
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultado>> listarResultadosQuestionario(@PathVariable Long id) {
        List<PerfilResultado> resultados = questionarioService.listarResultadosQuestionario(id);
        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerQuestionario(@PathVariable Long id) {
        questionarioService.removerQuestionario(id);
        return ResponseEntity.noContent().build();
    }
}