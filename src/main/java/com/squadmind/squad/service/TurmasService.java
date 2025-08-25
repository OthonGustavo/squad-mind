package com.squadmind.squad.service;

import com.squadmind.squad.dto.DTOMapper;
import com.squadmind.squad.dto.TurmasDTO;
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
public class TurmasService {

    private final TurmasRepository turmasRepository;
    private final GruposRepository gruposRepository;

    @Autowired
    public TurmasService(TurmasRepository turmaRepository, GruposRepository grupoRepository) {
        this.turmasRepository = turmaRepository;
        this.gruposRepository = grupoRepository;
    }

    // Criar nova turma
    public TurmasDTO criarTurma(Turmas turma) {
        turma.setCriadoEm();
        Turmas salvo = turmasRepository.save(turma);
        return DTOMapper.toTurmasDTO(salvo);
    }

    // Buscar turma por id
    public TurmasDTO buscarTurma(Long id) {
        Turmas turma = turmasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));
        return DTOMapper.toTurmasDTO(turma);
    }

    // Buscar todas as turmas
    public List<TurmasDTO> listarTurmas() {
        return turmasRepository.findAll()
                .stream()
                .map(DTOMapper::toTurmasDTO)
                .collect(Collectors.toList());
    }

    // Atualizar turma
    public TurmasDTO atualizarTurma(Long turmaId, Turmas turmaAtualizada) {
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));

        turma.setNomeTurma(turmaAtualizada.getNomeTurma());
        turma.setChaveEntrada(turmaAtualizada.getChaveEntrada());

        Turmas salvo = turmasRepository.save(turma);
        return DTOMapper.toTurmasDTO(salvo);
    }

    // Deletar turma
    public void deletarTurma(Long turmaId) {
        try {
            turmasRepository.deleteById(turmaId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Turma não encontrada");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar a turma devido a restrições de integridade");
        }
    }

    // Criar grupo dentro de uma turma
    public TurmasDTO criarGrupo(Long turmaId, Grupos grupo) {
        Turmas turma = turmasRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));

        grupo.setTurmas(turma);
        gruposRepository.save(grupo);
        return DTOMapper.toTurmasDTO(turma); // retorna a turma atualizada com o grupo criado
    }

    // Listar grupos de uma turma (opcional: pode criar DTO de grupo se quiser)
    // public List<GruposDTO> listarGruposPorTurma(Long turmaId) {...}
}
