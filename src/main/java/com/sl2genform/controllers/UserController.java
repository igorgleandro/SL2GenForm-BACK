package com.sl2genform.controllers;

import com.sl2genform.dto.UserDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import com.sl2genform.mappers.UserMapper;
import com.sl2genform.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Tag(name = "getBooks", description = "retrieve all the user from the db")
    @CrossOrigin("http://localhost:5173")
    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userMapper.toDTOList((List<User>) userService.findAll());
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User savedUser = userService.save(userMapper.toEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDTO(savedUser)).getBody();


    }

}