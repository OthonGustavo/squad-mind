package com.squadmind.squad.service;

import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionarioService {

    private QuestionarioRepository questionarioRepository;
    private ProjetoRepository projetoRepository;

    // Criar questionário dentro de um projeto
    public Questionario criarQuestionario(Long projetoId, Questionario questionario) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        questionario.setProjeto(projeto);
        return questionarioRepository.save(questionario);
    }

    public Questionario buscarPorId(Long id) {
        return questionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));
    }

    public List<Questionario> listarTodos() {
        return questionarioRepository.findAll();
    }

    public List<PerfilResultado> listarResultadosQuestionario(Long questionarioId) {
        Questionario questionario = buscarPorId(questionarioId);
        return questionario.getPerfilResultados();
    }

    public void removerQuestionario(Long id) {
        questionarioRepository.deleteById(id);
    }
}
