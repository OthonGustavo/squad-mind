package com.squadmind.squad.service;

import com.squadmind.squad.dto.DTOMapper;
import com.squadmind.squad.dto.GruposDTO;
import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.exception.DatabaseException;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.GruposRepository;
import com.squadmind.squad.repository.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GruposService {

    private final GruposRepository gruposRepository;
    private final TurmasRepository turmasRepository;

    @Autowired
    public GruposService(GruposRepository gruposRepository, TurmasRepository turmasRepository) {
        this.gruposRepository = gruposRepository;
        this.turmasRepository = turmasRepository;
    }

    // Criar grupo
    public GruposDTO criarGrupo(Long turmaId, Grupos grupo) {
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));

        grupo.setTurmas(turma);
        Grupos salvo = gruposRepository.save(grupo);
        return DTOMapper.toGruposDTO(salvo);
    }

    // Buscar grupo por ID
    public GruposDTO buscarGrupo(Long id) {
        Grupos grupo = gruposRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado"));
        return DTOMapper.toGruposDTO(grupo);
    }

    // Listar todos os grupos
    public List<GruposDTO> listarGrupos() {
        return gruposRepository.findAll()
                .stream()
                .map(DTOMapper::toGruposDTO)
                .collect(Collectors.toList());
    }

    // Atualizar grupo
    public GruposDTO atualizarGrupo(Long grupoId, Grupos grupoAtualizado) {
        Grupos grupo = gruposRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado"));

        grupo.setNumeroGrupo(grupoAtualizado.getNumeroGrupo());

        Grupos salvo = gruposRepository.save(grupo);
        return DTOMapper.toGruposDTO(salvo);
    }

    // Deletar grupo
    public void deletarGrupo(Long grupoId) {
        try {
            gruposRepository.deleteById(grupoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Grupo não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar o grupo devido a restrições de integridade");
        }
    }

    // Listar grupos de uma turma
    public List<GruposDTO> listarGruposPorTurma(Long turmaId) {
        List<Grupos> grupos = gruposRepository.findByTurma_Id(turmaId);
        return grupos.stream()
                .map(DTOMapper::toGruposDTO)
                .collect(Collectors.toList());
    }
}
