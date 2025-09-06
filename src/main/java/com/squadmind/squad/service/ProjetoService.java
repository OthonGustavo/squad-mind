package com.squadmind.squad.service;
import com.squadmind.squad.entity.*;
import com.squadmind.squad.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public List<Participante> listarParticipantes(Long projetoId) {
        Projeto projeto = buscarPorId(projetoId);
        return projeto.getParticipantes();
    }

    public List<Grupo> listarGruposDoProjeto(Long projetoId) {
        Projeto projeto = buscarPorId(projetoId);
        return projeto.getGrupos();
    }

    public List<Questionario> listarQuestionariosDoProjeto(Long projetoId) {
        Projeto projeto = buscarPorId(projetoId);
        return projeto.getQuestionarios();
    }

    public List<PerfilResultado> listarResultadosProjeto(Long projetoId) {
        Projeto projeto = buscarPorId(projetoId);
        return projeto.getPerfilResultados();
    }

    public void removerProjeto(Long id) {
        projetoRepository.deleteById(id);
    }
}

