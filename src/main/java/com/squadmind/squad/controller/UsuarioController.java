package com.squadmind.squad.controller;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.entity.Participante;
import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(new UsuarioDTO(novoUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/{id}/participacoes")
    public ResponseEntity<List<Participante>> listarParticipacoes(@PathVariable Long id) {
        List<Participante> participacoes = usuarioService.listarParticipacoes(id);
        return ResponseEntity.ok(participacoes);
    }

    @GetMapping("/{id}/grupos")
    public ResponseEntity<List<GrupoMembros>> listarGruposDoUsuario(@PathVariable Long id) {
        List<GrupoMembros> grupos = usuarioService.listarGruposDoUsuario(id);
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<PerfilResultado>> listarResultadosUsuario(@PathVariable Long id) {
        List<PerfilResultado> resultados = usuarioService.listarResultadosUsuario(id);
        return ResponseEntity.ok(resultados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }
}