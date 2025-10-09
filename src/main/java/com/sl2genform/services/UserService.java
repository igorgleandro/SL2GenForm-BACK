package com.sl2genform.services;

import com.sl2genform.entities.User;
import com.sl2genform.repositories.UserRepository;
import com.sl2genform.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService  {

    UserRepository userRepository;

    public User save(User user){
        System.out.println("Saving user....");
        userRepository.save(user);
        System.out.println("...Saved");

        return user;
    }

    public User update(User user){
        System.out.println("Updating user....");
        User updatedUser = userRepository.save(user);
        System.out.println("...Updated");

        return updatedUser;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new UserDetailsImpl(user);
    }

}

