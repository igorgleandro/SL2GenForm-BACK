package com.sl2genform.services;

import com.sl2genform.entities.Insurer;
import com.sl2genform.entities.User;
import com.sl2genform.repositories.InsurerRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class InsurerService {
    InsurerRepository insurerRepository;

    public Insurer save(Insurer insurer){
        System.out.println("Saving insurer....");
        insurerRepository.save(insurer);
        System.out.println("...Saved");

        return insurer;
    }

    public Optional<Insurer> findById(String id){
        return insurerRepository.findById(id);
    }

    public void deleteById(String id){
        insurerRepository.deleteById(id);
    }

    public Iterable<Insurer> findAll(){
        return insurerRepository.findAll();
    }


}