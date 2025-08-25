package com.squadmind.squad.service;

import com.squadmind.squad.entity.Respostas;
import com.squadmind.squad.entity.Turmas;
import com.squadmind.squad.entity.Usuario;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.RespostasRepository;
import com.squadmind.squad.repository.TurmasRepository;
import com.squadmind.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostasService {


    private final RespostasRepository respostasRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurmasRepository turmaRepository;

    @Autowired
    public RespostasService(RespostasRepository respostasRepository,
                            UsuarioRepository usuarioRepository,
                            TurmasRepository turmaRepository) {
        this.respostasRepository = respostasRepository;
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
    }

    // Criar respostas de um aluno em uma turma
    public Respostas criarRespostas(Long alunoId, Long turmaId, Respostas respostas) {
        Usuario aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Turmas turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        respostas.setAlunoId(aluno);
        respostas.setTurmasId(turma);

        return respostasRepository.save(respostas);
    }

    // Listar todas as respostas
    public List<Respostas> listarRespostas() {
        return respostasRepository.findAll();
    }

    // Listar respostas de um aluno específico
    public List<Respostas> listarRespostasDoAluno(Long alunoId) {
        return respostasRepository.findByAlunoId_Id(alunoId);
    }

    // Listar respostas de uma turma específica
    public List<Respostas> listarRespostasDaTurma(Long turmaId) {
        return respostasRepository.findByTurmasId_Id(turmaId);
    }

    // Buscar respostas por ID
    public Respostas buscarRespostas(Long respostasId) {
        return respostasRepository.findById(respostasId)
                .orElseThrow(() -> new RuntimeException("Respostas não encontradas"));
    }

    // Atualizar respostas (pontuações e perfil)
    public Respostas atualizarRespostas(Long respostasId, Respostas respostasAtualizadas) {
        Respostas respostas = buscarRespostas(respostasId);

        respostas.setPontuacaoD(respostasAtualizadas.getPontuacaoD());
        respostas.setPontuacaoI(respostasAtualizadas.getPontuacaoI());
        respostas.setPontuacaoS(respostasAtualizadas.getPontuacaoS());
        respostas.setPontuacaoC(respostasAtualizadas.getPontuacaoC());
        respostas.setPerfilDominante(respostasAtualizadas.getPerfilDominante());
        respostas.setRespostas_json(respostasAtualizadas.getRespostas_json());

        return respostasRepository.save(respostas);
    }

    // Remover respostas
    public void removerRespostas(Long respostasId) {
        Respostas respostas = buscarRespostas(respostasId);
        respostasRepository.delete(respostas);
    }

}
