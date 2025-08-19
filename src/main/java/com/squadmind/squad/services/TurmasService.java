package com.squadmind.squad.services;

import com.squadmind.squad.entities.Turmas;
import com.squadmind.squad.repositories.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmasService {

    @Autowired
    TurmasRepository repository;

    public List<Turmas> findAll(){
        return repository.findAll();
    }

    public Turmas findById(Long id){
        Optional<Turmas> obj = repository.findById(id);
        return obj.get();
    }

}
