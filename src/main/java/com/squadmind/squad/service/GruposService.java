package com.squadmind.squad.service;

import com.squadmind.squad.entity.Grupos;
import com.squadmind.squad.repository.GruposRepository;
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
