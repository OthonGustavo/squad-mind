package com.squadmind.squad.service;

import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.GruposRepository;
import com.squadmind.squad.repository.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GruposService {


    private final GruposRepository grupoRepository;
    private final TurmasRepository turmaRepository;

    public GruposService(GruposRepository grupoRepository, TurmasRepository turmaRepository) {
        this.grupoRepository = grupoRepository;
        this.turmaRepository = turmaRepository;
    }

    // Criar grupo em uma turma
    public Grupos criarGrupo(Long turmaId, Grupos grupo) {
        Turmas turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        grupo.setTurmas(turma); // associa grupo à turma
        return grupoRepository.save(grupo);
    }

    // Listar todos os grupos
    public List<Grupos> listarGrupos() {
        return grupoRepository.findAll();
    }

    // Listar grupos de uma turma específica
    public List<Grupos> listarGruposPorTurma(Long turmaId) {
        return grupoRepository.findByTurma_Id(turmaId);
    }

    // Buscar grupo por ID
    public Grupos buscarGrupo(Long grupoId) {
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
    }

    // Atualizar grupo (por exemplo, alterar número do grupo)
    public Grupos atualizarGrupo(Long grupoId, Integer numeroGrupo) {
        Grupos grupo = buscarGrupo(grupoId);
        grupo.setNumeroGrupo(numeroGrupo);
        return grupoRepository.save(grupo);
    }

    // Remover grupo
    public void removerGrupo(Long grupoId) {
        Grupos grupo = buscarGrupo(grupoId);
        grupoRepository.delete(grupo);
    }


}
