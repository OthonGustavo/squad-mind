package com.squadmind.squad.service;

import com.squadmind.squad.entity.PerguntasTecnicas;
import com.squadmind.squad.exception.ResourceNotFoundException;
import com.squadmind.squad.repository.PerguntasTecnicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerguntasTecnicasService {

    @Autowired
    PerguntasTecnicasRepository repository;

    public List<PerguntasTecnicas> findAll(){
        return repository.findAll();
    }

    public PerguntasTecnicas findById(Long id){
        Optional<PerguntasTecnicas> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("PerguntaTecnica não enctrada"));
    }

    public PerguntasTecnicas insert(PerguntasTecnicas obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
