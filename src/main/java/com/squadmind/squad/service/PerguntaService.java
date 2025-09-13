package com.squadmind.squad.service;

import com.squadmind.squad.dto.PerguntaDTO;
import com.squadmind.squad.entity.Pergunta;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Tag;
import com.squadmind.squad.mapper.PerguntaMapper;
import com.squadmind.squad.repository.PerguntaRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    @Autowired
    private TagRepository tagRepository;

    // --- Criar pergunta ---
    public PerguntaDTO criarPergunta(Long questionarioId, Long tagId, PerguntaDTO perguntaDTO) {
        Questionario questionario = buscarQuestionario(questionarioId);
        Tag tag = buscarTag(tagId);

        Pergunta pergunta = PerguntaMapper.toEntity(perguntaDTO);
        pergunta.setQuestionario(questionario);
        pergunta.setTag(tag);

        Pergunta saved = perguntaRepository.save(pergunta);
        return PerguntaMapper.toDTO(saved);
    }

    // --- Listar perguntas por questionário ---
    public List<PerguntaDTO> listarPerguntasPorQuestionario(Long questionarioId) {
        return perguntaRepository.findByQuestionario_Id(questionarioId)
                .stream()
                .map(PerguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Listar perguntas por tag ---
    public List<PerguntaDTO> listarPerguntasPorTag(Long tagId) {
        return perguntaRepository.findByTag_Id(tagId)
                .stream()
                .map(PerguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Buscar pergunta por ID ---
    public PerguntaDTO buscarPorId(Long id) {
        return PerguntaMapper.toDTO(buscarPergunta(id));
    }

    // --- Listar todas as perguntas ---
    public List<PerguntaDTO> listarTodas() {
        return perguntaRepository.findAll()
                .stream()
                .map(PerguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // --- Remover pergunta ---
    public void remover(Long id) {
        perguntaRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---
    private Pergunta buscarPergunta(Long id) {
        return perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
    }

    private Questionario buscarQuestionario(Long id) {
        return questionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
    }

    private Tag buscarTag(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag não encontrada"));
    }
}
