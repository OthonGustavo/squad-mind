package com.squadmind.squad.controller;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.dto.ParticipanteDTO;
import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // --- Criar usuário ---
    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO dto) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(dto);
        return ResponseEntity.ok(novoUsuario);
    }

    // --- Buscar usuário por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // --- Listar todos os usuários ---
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuariosDTO);
    }

    // --- Listar participações do usuário ---
    @GetMapping("/{id}/participacoes")
    public ResponseEntity<List<ParticipanteDTO>> listarParticipacoes(@PathVariable Long id) {
        List<ParticipanteDTO> participacoesDTO = usuarioService.listarParticipacoes(id);
        return ResponseEntity.ok(participacoesDTO);
    }

    // --- Listar grupos do usuário ---
    @GetMapping("/{id}/grupos")
    public ResponseEntity<List<GrupoMembrosDTO>> listarGruposDoUsuario(@PathVariable Long id) {
        List<GrupoMembrosDTO> gruposDTO = usuarioService.listarGruposDoUsuario(id);
        return ResponseEntity.ok(gruposDTO);
    }

    // --- Listar resultados do usuário ---
    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultadoDTO>> listarResultadosUsuario(@PathVariable Long id) {
        List<PerfilResultadoDTO> resultadosDTO = usuarioService.listarResultadosUsuario(id);
        return ResponseEntity.ok(resultadosDTO);
    }

    // --- Remover usuário ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
