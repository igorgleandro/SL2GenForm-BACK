package com.sl2genform.controllers;

import com.sl2genform.dto.UserDTO;

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
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://sl2genform-app-production.up.railway.app"})
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Tag(name = "getBooks", description = "retrieve all the user from the db")
    @CrossOrigin(origins = {"http://localhost:5173", "https://sl2genform-app-production.up.railway.app"})
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
    @CrossOrigin(origins = {"http://localhost:5173", "https://sl2genform-app-production.up.railway.app"})
    @PatchMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO userDTO) {


        Optional<User> existingUserOpt = userService.findById(Math.toIntExact(id));
        if (existingUserOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = existingUserOpt.get();

        if (userDTO.getName() != null) {
            existingUser.setName(userDTO.getName());
        }

        if (userDTO.getSurname() != null) {
            existingUser.setSurname(userDTO.getSurname());
        }

        if (userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }

        if (userDTO.getRole() != null) {
            existingUser.setRole(userDTO.getRole());
        }

        if (userDTO.getTheme() != null) {
            existingUser.setTheme(userDTO.getTheme());
        }

        if (userDTO.getAvatar() != null) {
            existingUser.setAvatar(userDTO.getAvatar());
        }

        // Only update password if it's provided and not blank
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }


        User updatedUser = userService.update(existingUser);

        return ResponseEntity.ok(userMapper.toDTO(updatedUser));
    }

    @CrossOrigin(origins = {"http://localhost:5173", "https://sl2genform-app-production.up.railway.app"})
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> existingUser = userService.findById(Math.toIntExact(id));

        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }


}