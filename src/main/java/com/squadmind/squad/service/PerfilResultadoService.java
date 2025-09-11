package com.squadmind.squad.service;

import com.squadmind.squad.entity.PerfilResultado;
import com.squadmind.squad.entity.Projeto;
import com.squadmind.squad.entity.Questionario;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.repository.PerfilResultadoRepository;
import com.squadmind.squad.repository.ProjetoRepository;
import com.squadmind.squad.repository.QuestionarioRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilResultadoService {

    @Autowired
    private PerfilResultadoRepository perfilResultadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    public PerfilResultado salvarResultado(Long usuarioId, Long projetoId, Long questionarioId, PerfilResultado resultado) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        Questionario questionario = questionarioRepository.findById(questionarioId)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));

        resultado.setUsuario(usuario);
        resultado.setProjeto(projeto);
        resultado.setQuestionario(questionario);

        return perfilResultadoRepository.save(resultado);
    }

    public PerfilResultado buscarPorId(Long id) {
        return perfilResultadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultado não encontrado"));
    }

    public List<PerfilResultado> listarTodos() {
        return perfilResultadoRepository.findAll();
    }

    public List<PerfilResultado> listarPorUsuario(Long usuarioId) {
        return perfilResultadoRepository.findByUsuario_Id(usuarioId);
    }

    public List<PerfilResultado> listarPorProjeto(Long projetoId) {
        return perfilResultadoRepository.findByProjeto_Id(projetoId);
    }

    public List<PerfilResultado> listarPorQuestionario(Long questionarioId) {
        return perfilResultadoRepository.findByQuestionario_Id(questionarioId);
    }

    public void removerResultado(Long id) {
        perfilResultadoRepository.deleteById(id);
    }
}
