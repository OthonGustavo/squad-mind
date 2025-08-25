package com.squadmind.squad.controller;

import com.squadmind.squad.dto.UsuarioDTO;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    // Criar turma para um professor
    @PostMapping("/{professorId}/turmas")
    public Turmas criarTurma(@PathVariable Long professorId, @RequestBody Turmas turma) {
        return usuarioService.criarTurma(professorId, turma);
    }

    @GetMapping("/{professorId}/turmas")
    public List<Turmas> listarTurmasPorProfessor(@PathVariable Long professorId) {
        return usuarioService.listarTurmasPorProfessor(professorId);
    }
}
