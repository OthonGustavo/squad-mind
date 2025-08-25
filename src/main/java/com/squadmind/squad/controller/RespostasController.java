package com.squadmind.squad.controller;

import com.squadmind.squad.dto.RespostasDTO;
import com.squadmind.squad.dto.RespostasInputDTO;
import com.squadmind.squad.entity.Respostas;
import com.squadmind.squad.service.RespostasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respostas")
public class RespostasController {

    @Autowired
    private RespostasService respostasService;

    // Criar nova resposta
    @PostMapping
    public RespostasDTO criarResposta(@RequestBody RespostasInputDTO input) {
        Respostas respostas = new Respostas();
        respostas.setPontuacaoD(input.getPontuacaoD());
        respostas.setPontuacaoI(input.getPontuacaoI());
        respostas.setPontuacaoS(input.getPontuacaoS());
        respostas.setPontuacaoC(input.getPontuacaoC());
        respostas.setPerfilDominante(input.getPerfilDominante());
        respostas.setRespostas_json(input.getRespostas_json());

        return respostasService.criarResposta(input.getAlunoId(), input.getTurmaId(), respostas);
    }

    // Buscar resposta por ID
    @GetMapping("/{id}")
    public RespostasDTO buscarResposta(@PathVariable Long id) {
        return respostasService.buscarResposta(id);
    }

    // Listar todas as respostas
    @GetMapping
    public List<RespostasDTO> listarRespostas() {
        return respostasService.listarRespostas();
    }

    // Atualizar resposta
    @PutMapping("/{id}")
    public RespostasDTO atualizarResposta(@PathVariable Long id, @RequestBody RespostasDTO input) {
        Respostas respostasAtualizada = new Respostas();
        respostasAtualizada.setPontuacaoD(input.getPontuacaoD());
        respostasAtualizada.setPontuacaoI(input.getPontuacaoI());
        respostasAtualizada.setPontuacaoS(input.getPontuacaoS());
        respostasAtualizada.setPontuacaoC(input.getPontuacaoC());
        respostasAtualizada.setPerfilDominante(input.getPerfilDominante());
        respostasAtualizada.setRespostas_json(input.getRespostas_json());

        return respostasService.atualizarResposta(id, respostasAtualizada);
    }

    // Deletar resposta
    @DeleteMapping("/{id}")
    public void deletarResposta(@PathVariable Long id) {
        respostasService.deletarResposta(id);
    }
}
