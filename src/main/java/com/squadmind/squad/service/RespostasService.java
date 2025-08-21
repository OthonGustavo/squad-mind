package com.squadmind.squad.service;

import com.squadmind.squad.entity.Respostas;
import com.squadmind.squad.repository.RespostasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostasService {

    @Autowired
    RespostasRepository repository;

    public List<Respostas> findAll(){
        return repository.findAll();
    }

    public Respostas findById(Long id){
        Optional<Respostas> obj = repository.findById(id);
        return obj.get();
    }

    public Respostas insert(Respostas obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
