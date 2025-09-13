package com.squadmind.squad.service;

import com.squadmind.squad.dto.PerfilResultadoDTO;
import com.squadmind.squad.dto.QuestionarioDTO;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.mapper.PerfilResultadoMapper;
import com.squadmind.squad.mapper.QuestionarioMapper;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionarioService {

    @Autowired
    private QuestionarioRepository questionarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    // --- Criar questionário ---
    public QuestionarioDTO criarQuestionario(Long projetoId, QuestionarioDTO dto) {
        // Converte DTO para entidade
        Questionario questionario = QuestionarioMapper.toEntity(dto);

        // Associa projeto
        questionario.setProjeto(buscarProjeto(projetoId));

        // Salva no repositório
        Questionario saved = questionarioRepository.save(questionario);

        // Converte de volta para DTO e retorna
        return QuestionarioMapper.toDTO(saved);
    }


    // --- Buscar por ID ---
    public QuestionarioDTO buscarPorId(Long id) {
        return QuestionarioMapper.toDTO(buscarQuestionario(id));
    }

    // --- Listar todos ---
    public List<QuestionarioDTO> listarTodos() {
        return questionarioRepository.findAll()
                .stream()
                .map(QuestionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar resultados do questionário ---
    public List<PerfilResultadoDTO> listarResultadosQuestionario(Long questionarioId) {
        Questionario questionario = buscarQuestionario(questionarioId);
        return questionario.getPerfilResultados()
                .stream()
                .map(PerfilResultadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover ---
    public void removerQuestionario(Long id) {
        questionarioRepository.deleteById(id);
    }

    // --- Métodos auxiliares privados ---
    private Questionario buscarQuestionario(Long id) {
        return questionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
    }

    private Projeto buscarProjeto(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }
}
