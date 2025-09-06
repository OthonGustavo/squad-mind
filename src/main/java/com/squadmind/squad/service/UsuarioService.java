package com.squadmind.squad.service;

import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.entity.Participante;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Participante> listarParticipacoes(Long usuarioId) {
        Usuario usuario = buscarPorId(usuarioId);
        return usuario.getParticipantes();
    }

    public List<GrupoMembros> listarGruposDoUsuario(Long usuarioId) {
        Usuario usuario = buscarPorId(usuarioId);
        return usuario.getGrupoMembros();
    }

    public List<PerfilResultado> listarResultadosUsuario(Long usuarioId) {
        Usuario usuario = buscarPorId(usuarioId);
        return usuario.getPerfilResultados();
    }

    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
