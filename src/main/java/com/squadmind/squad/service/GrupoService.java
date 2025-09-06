package com.squadmind.squad.service;

import com.squadmind.squad.entity.Grupo;
import com.squadmind.squad.entity.GrupoMembros;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.repository.GrupoRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    // Criar grupo dentro de um projeto
    public Grupo criarGrupo(Long projetoId, Grupo grupo) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        grupo.setProjeto(projeto);
        return grupoRepository.save(grupo);
    }

    public Grupo buscarPorId(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
    }

    public List<Grupo> listarTodos() {
        return grupoRepository.findAll();
    }

    public List<GrupoMembros> listarMembrosDoGrupo(Long grupoId) {
        Grupo grupo = buscarPorId(grupoId);
        return grupo.getGrupoMembros();
    }

    public void removerGrupo(Long id) {
        grupoRepository.deleteById(id);
    }
}