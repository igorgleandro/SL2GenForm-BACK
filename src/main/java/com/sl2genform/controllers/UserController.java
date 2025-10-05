package com.sl2genform.controllers;

import com.sl2genform.dto.UserDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import com.sl2genform.mappers.UserMapper;
import com.sl2genform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userMapper.toDTOList((List<User>) userService.findAll());
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        User savedUser = userService.save(userMapper.toEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDTO(savedUser)).getBody();

    }

}