package com.squadmind.squad.service;

import com.squadmind.squad.entity.Tag;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.repository.TagRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final QuestionarioRepository questionarioRepository;

    public TagService(TagRepository tagRepository, QuestionarioRepository questionarioRepository) {
        this.tagRepository = tagRepository;
        this.questionarioRepository = questionarioRepository;
    }

    public Tag criarTag(Long questionarioId, Tag tag) {
        Questionario questionario = questionarioRepository.findById(questionarioId)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));

        tag.setQuestionario(questionario);
        return tagRepository.save(tag);
    }

    public List<Tag> listarTagsPorQuestionario(Long questionarioId) {
        return tagRepository.findByQuestionario_Id(questionarioId);
    }

    public Tag buscarPorId(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag não encontrada"));
    }

    public List<Tag> listarTodas() {
        return tagRepository.findAll();
    }

    public void remover(Long id) {
        tagRepository.deleteById(id);
    }
}
