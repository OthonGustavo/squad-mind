package com.squadmind.squad.service;

import com.squadmind.squad.dto.GrupoDTO;
import com.squadmind.squad.dto.GrupoMembrosDTO;
import com.squadmind.squad.entity.Grupo;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.mapper.GrupoMapper;
import com.squadmind.squad.mapper.GrupoMembrosMapper;
import com.squadmind.squad.repository.GrupoRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    // --- Criar grupo dentro de um projeto ---
    public GrupoDTO criarGrupo(Long projetoId, GrupoDTO dto) {
        Projeto projeto = buscarProjeto(projetoId);

        Grupo grupo = GrupoMapper.toEntity(dto);
        grupo.setProjeto(projeto);

        Grupo saved = grupoRepository.save(grupo);
        return GrupoMapper.toDTO(saved);
    }

    // --- Buscar grupo por ID ---
    public GrupoDTO buscarPorId(Long id) {
        return GrupoMapper.toDTO(buscarGrupo(id));
    }

    // --- Listar todos os grupos ---
    public List<GrupoDTO> listarTodos() {
        return grupoRepository.findAll()
                .stream()
                .map(GrupoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar membros de um grupo ---
    public List<GrupoMembrosDTO> listarMembrosDoGrupo(Long grupoId) {
        Grupo grupo = buscarGrupo(grupoId);
        return grupo.getGrupoMembros()
                .stream()
                .map(GrupoMembrosMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover grupo ---
    public void removerGrupo(Long id) {
        grupoRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private Grupo buscarGrupo(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
    }

    private Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }
}
