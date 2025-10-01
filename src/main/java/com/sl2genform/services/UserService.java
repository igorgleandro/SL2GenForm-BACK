package com.sl2genform.services;

import com.sl2genform.entities.User;
import com.sl2genform.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    public User save(User user){
        System.out.println("Saving user....");
        userRepository.save(user);
        System.out.println("...Saved");

        return user;
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }


}

