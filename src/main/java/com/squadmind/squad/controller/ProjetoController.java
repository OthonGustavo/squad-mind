package com.squadmind.squad.controller;

import com.squadmind.squad.dto.ProjetoDTO;
import com.squadmind.squad.entity.*;
import com.squadmind.squad.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody Projeto projeto) {
        Projeto novoProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.ok(new ProjetoDTO(novoProjeto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> buscarPorId(@PathVariable Long id) {
        Projeto projeto = projetoService.buscarPorId(id);
        return ResponseEntity.ok(new ProjetoDTO(projeto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listarProjetos() {
        List<Projeto> projetos = projetoService.listarProjetos();
        List<ProjetoDTO> projetosDTO = projetos.stream().map(ProjetoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(projetosDTO);
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity<List<Participante>> listarParticipantes(@PathVariable Long id) {
        List<Participante> participantes = projetoService.listarParticipantes(id);
        return ResponseEntity.ok(participantes);
    }

    @GetMapping("/{id}/grupos")
    public ResponseEntity<List<Grupo>> listarGruposDoProjeto(@PathVariable Long id) {
        List<Grupo> grupos = projetoService.listarGruposDoProjeto(id);
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}/questionarios")
    public ResponseEntity<List<Questionario>> listarQuestionariosDoProjeto(@PathVariable Long id) {
        List<Questionario> questionarios = projetoService.listarQuestionariosDoProjeto(id);
        return ResponseEntity.ok(questionarios);
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultado>> listarResultadosProjeto(@PathVariable Long id) {
        List<PerfilResultado> resultados = projetoService.listarResultadosProjeto(id);
        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProjeto(@PathVariable Long id) {
        projetoService.removerProjeto(id);
        return ResponseEntity.noContent().build();
    }
}