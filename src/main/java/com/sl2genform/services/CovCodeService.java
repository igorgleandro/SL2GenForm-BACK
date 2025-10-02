package com.sl2genform.services;

import com.sl2genform.entities.CovCode;
import com.sl2genform.repositories.CovCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CovCodeService {

    CovCodeRepository covCodeRepository;

    public CovCode save(CovCode covCode){
        System.out.println("Saving CovCode....");
        covCodeRepository.save(covCode);
        System.out.println("...Saved");

        return covCode;
    }

    public Optional<CovCode> findById(Integer id){
        return covCodeRepository.findById(id);
    }

    public void deleteById(Integer id){
        covCodeRepository.deleteById(id);
    }

    public Iterable<CovCode> findAll(){
        return covCodeRepository.findAll();
    }
}
