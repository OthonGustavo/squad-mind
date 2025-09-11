package com.squadmind.squad.service;

import com.squadmind.squad.entity.Pergunta;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Tag;
import com.squadmind.squad.repository.PerguntaRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {

    private PerguntaRepository perguntaRepository;
    private QuestionarioRepository questionarioRepository;
    private TagRepository tagRepository;

    public Pergunta criarPergunta(Long questionarioId, Long tagId, Pergunta pergunta) {
        Questionario questionario = questionarioRepository.findById(questionarioId)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new RuntimeException("Tag não encontrada"));

        pergunta.setQuestionario(questionario);
        pergunta.setTag(tag);

        return perguntaRepository.save(pergunta);
    }

    public List<Pergunta> listarPerguntasPorQuestionario(Long questionarioId) {
        return perguntaRepository.findByQuestionario_Id(questionarioId);
    }

    public List<Pergunta> listarPerguntasPorTag(Long tagId) {
        return perguntaRepository.findByTag_Id(tagId);
    }

    public Pergunta buscarPorId(Long id) {
        return perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
    }

    public List<Pergunta> listarTodas() {
        return perguntaRepository.findAll();
    }

    public void remover(Long id) {
        perguntaRepository.deleteById(id);
    }
}
