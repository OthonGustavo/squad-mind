package com.squadmind.squad.service;

import com.squadmind.squad.dto.ProjetoQuestionarioDTO;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.ProjetoQuestionario;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.mapper.ProjetoQuestionarioMapper;
import com.squadmind.squad.repository.ProjetoQuestionarioRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoQuestionarioService {

    @Autowired
    private ProjetoQuestionarioRepository pqRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    // Criar associação entre projetos e questionários
    public ProjetoQuestionarioDTO criarAssociacao(ProjetoQuestionarioDTO dto) {
        ProjetoQuestionario entity = ProjetoQuestionarioMapper.toEntity(dto);

        List<Projeto> projetos = dto.getProjetos()
                .stream()
                .map(id -> projetoRepository.findById(dto.getId())
                        .orElseThrow(() -> new RuntimeException("Projeto não encontrado: " + id)))
                .collect(Collectors.toList());

        List<Questionario> questionarios = dto.getQuestionarios()
                .stream()
                .map(id -> questionarioRepository.findById(dto.getId())
                        .orElseThrow(() -> new RuntimeException("Questionário não encontrado: " + id)))
                .collect(Collectors.toList());

        entity.setProjeto(projetos);
        entity.setQuestionario(questionarios);

        ProjetoQuestionario saved = pqRepository.save(entity);
        return ProjetoQuestionarioMapper.toDTO(saved);
    }

    public ProjetoQuestionarioDTO buscarPorId(Long id) {
        ProjetoQuestionario pq = pqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Associação não encontrada"));
        return ProjetoQuestionarioMapper.toDTO(pq);
    }

    public List<ProjetoQuestionarioDTO> listarTodos() {
        return pqRepository.findAll()
                .stream()
                .map(ProjetoQuestionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void remover(Long id) {
        pqRepository.deleteById(id);
    }
}
