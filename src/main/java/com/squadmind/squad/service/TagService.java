package com.squadmind.squad.service;

import com.squadmind.squad.dto.TagDTO;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Tag;
import com.squadmind.squad.mapper.TagMapper;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    // Criar tag
    public TagDTO criarTag(Long questionarioId, TagDTO dto) {
        Questionario questionario = questionarioRepository.findById(questionarioId)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));

        Tag tag = TagMapper.toEntity(dto);
        tag.setQuestionario(questionario);

        Tag saved = tagRepository.save(tag);
        return TagMapper.toDTO(saved);
    }

    // Listar tags por questionário
    public List<TagDTO> listarTagsPorQuestionario(Long questionarioId) {
        return tagRepository.findByQuestionario_Id(questionarioId)
                .stream()
                .map(TagMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar tag por ID
    public TagDTO buscarPorId(Long id) {
        return TagMapper.toDTO(buscarTag(id));
    }

    // Listar todas as tags
    public List<TagDTO> listarTodas() {
        return tagRepository.findAll()
                .stream()
                .map(TagMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Remover tag
    public void remover(Long id) {
        tagRepository.deleteById(id);
    }

    // --- Métodos auxiliares privados ---
    private Tag buscarTag(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag não encontrada"));
    }

    private Questionario buscarQuestionario(Long id) {
        return questionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
    }
}
