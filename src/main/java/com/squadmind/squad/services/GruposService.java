package com.squadmind.squad.services;

import com.squadmind.squad.entities.Grupos;
import com.squadmind.squad.repositories.GruposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GruposService {

    @Autowired
    GruposRepository repository;

    public List<Grupos> findAll(){
        return repository.findAll();
    }

    public Grupos findById(Long id){
        Optional<Grupos> obj = repository.findById(id);
        return obj.get();
    }

    public Grupos insert(Grupos obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
