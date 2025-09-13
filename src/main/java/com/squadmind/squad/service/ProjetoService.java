package com.squadmind.squad.service;

import com.squadmind.squad.dto.*;
import com.squadmind.squad.entity.*;
import com.squadmind.squad.mapper.*;
import com.squadmind.squad.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoDTO criarProjeto(ProjetoDTO dto) {
        Projeto projeto = ProjetoMapper.toEntity(dto);
        Projeto saved = projetoRepository.save(projeto);
        return ProjetoMapper.toDTO(saved);
    }

    public ProjetoDTO buscarPorId(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        return ProjetoMapper.toDTO(projeto);
    }

    public List<ProjetoDTO> listarProjetos() {
        return projetoRepository.findAll()
                .stream()
                .map(ProjetoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ParticipanteDTO> listarParticipantes(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return projeto.getParticipantes()
                .stream()
                .map(ParticipanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<GrupoDTO> listarGruposDoProjeto(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return projeto.getGrupos()
                .stream()
                .map(GrupoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<QuestionarioDTO> listarQuestionariosDoProjeto(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return projeto.getQuestionarios()
                .stream()
                .map(QuestionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PerfilResultadoDTO> listarResultadosProjeto(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return projeto.getPerfilResultados()
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void removerProjeto(Long id) {
        projetoRepository.deleteById(id);
    }
}
