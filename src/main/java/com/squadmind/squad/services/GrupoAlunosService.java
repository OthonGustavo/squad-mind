package com.squadmind.squad.services;

import com.squadmind.squad.entities.GrupoAlunos;
import com.squadmind.squad.repositories.GrupoAlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoAlunosService {

    @Autowired
    GrupoAlunosRepository repository;

    public List<GrupoAlunos> findAll(){
        return repository.findAll();
    }

    public GrupoAlunos findById(Long id){
        Optional<GrupoAlunos> obj = repository.findById(id);
        return obj.get();
    }

    public GrupoAlunos insert(GrupoAlunos obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
