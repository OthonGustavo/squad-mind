package com.squadmind.squad.service;

import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.entity.Grupo;
import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.mapper.GrupoMembrosMapper;
import com.squadmind.squad.repository.GrupoMembrosRepository;
import com.squadmind.squad.repository.GrupoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoMembrosService {

    @Autowired
    private GrupoMembrosRepository grupoMembrosRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // --- Adicionar usuário em um grupo ---
    public GrupoMembrosDTO adicionarMembro(Long grupoId, Long usuarioId, Boolean lider) {
        Grupo grupo = buscarGrupo(grupoId);
        Usuario usuario = buscarUsuario(usuarioId);

        GrupoMembros membro = new GrupoMembros();
        membro.setGrupo(grupo);
        membro.setUsuario(usuario);
        membro.setLiderGrupo(lider);

        GrupoMembros saved = grupoMembrosRepository.save(membro);
        return GrupoMembrosMapper.toDTO(saved);
    }

    // --- Buscar membro por ID ---
    public GrupoMembrosDTO buscarPorId(Long id) {
        return GrupoMembrosMapper.toDTO(buscarMembro(id));
    }

    // --- Listar todos os membros ---
    public List<GrupoMembrosDTO> listarTodos() {
        return grupoMembrosRepository.findAll()
                .stream()
                .map(GrupoMembrosMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover membro ---
    public void removerMembro(Long id) {
        grupoMembrosRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private GrupoMembros buscarMembro(Long id) {
        return grupoMembrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
    }

    private Grupo buscarGrupo(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
