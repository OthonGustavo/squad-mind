package com.squadmind.squad.controller;

import com.squadmind.squad.dto.TipoDTO;
import com.squadmind.squad.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    // Criar novo tipo
    @PostMapping
    public ResponseEntity<TipoDTO> criarTipo(@RequestBody TipoDTO dto) {
        TipoDTO novoTipo = tipoService.criarTipo(dto);
        return ResponseEntity.ok(novoTipo);
    }

    // Buscar tipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> buscarPorId(@PathVariable Long id) {
        TipoDTO tipo = tipoService.buscarPorId(id);
        return ResponseEntity.ok(tipo);
    }

    // Listar todos os tipos
    @GetMapping
    public ResponseEntity<List<TipoDTO>> listarTodos() {
        List<TipoDTO> tipos = tipoService.listarTodos();
        return ResponseEntity.ok(tipos);
    }

    // Remover tipo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTipo(@PathVariable Long id) {
        tipoService.removerTipo(id);
        return ResponseEntity.noContent().build();
    }
}
