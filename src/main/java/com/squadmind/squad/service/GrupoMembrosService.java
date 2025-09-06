package com.squadmind.squad.service;

import com.squadmind.squad.entity.Grupo;
import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.repository.GrupoMembrosRepository;
import com.squadmind.squad.repository.GrupoRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoMembrosService {

    @Autowired
    private GrupoMembrosRepository grupoMembrosRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Adicionar usuário em um grupo
    public GrupoMembros adicionarMembro(Long grupoId, Long usuarioId, Boolean lider) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        GrupoMembros membro = new GrupoMembros();
        membro.setGrupo_id(grupo);
        membro.setUsuario_id(usuario);
        membro.setLider_grupo(lider);

        return grupoMembrosRepository.save(membro);
    }

    // Buscar membro por ID
    public GrupoMembros buscarPorId(Long id) {
        return grupoMembrosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
    }

    // Listar todos os vínculos usuário-grupo
    public List<GrupoMembros> listarTodos() {
        return grupoMembrosRepository.findAll();
    }

    // Remover membro
    public void removerMembro(Long id) {
        grupoMembrosRepository.deleteById(id);
    }
}
