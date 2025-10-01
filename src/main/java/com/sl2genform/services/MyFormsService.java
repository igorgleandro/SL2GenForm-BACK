package com.sl2genform.services;


import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import com.sl2genform.repositories.MyFormsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyFormsService {

    MyFormsRepository myFormsRepository;

    public void save(MyForms myForms){
        myFormsRepository.save(myForms);
    }

    public Iterable<MyForms> getAll(){
        return myFormsRepository.findAll();
    }

    public void deleteById(Integer id){
        myFormsRepository.deleteById(id);
    }

}
