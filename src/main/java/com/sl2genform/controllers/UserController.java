package com.sl2genform.controllers;

import com.sl2genform.dto.UserDTO;
import com.sl2genform.entities.User;
import com.sl2genform.mappers.UserMapper;
import com.sl2genform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userMapper.toDTOList((List<User>) userService.findAll());
    }
}