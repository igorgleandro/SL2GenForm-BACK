package com.sl2genform.controllers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.dto.UserDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import com.sl2genform.mappers.MyFormsMapper;
import com.sl2genform.services.MyFormsService;
import com.sl2genform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "sl2genform-app-production.up.railway.app"})
public class MyFormsController {

    private final MyFormsService myFormsService;
    private final MyFormsMapper myFormsMapper;
    private final UserService userService;

    @GetMapping("/myforms")
    public List<MyFormsDTO> getMyForms() {
        return myFormsMapper.toDTOList((List<MyForms>) myFormsService.getAll());
    }

    @GetMapping("/myforms/{id}")
    public ResponseEntity<MyFormsDTO> getMyForms(@PathVariable int id) {
        return myFormsService.getById(id)
                .map(myFormsMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/myforms/{id}")
    public ResponseEntity<Void> deleteMyForms(@PathVariable int id) {
        myFormsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/myforms/name/{name_insured}")
    public ResponseEntity<MyFormsDTO> getByNameInsured(@PathVariable String name_insured) {
        return myFormsService.getByNameInsured(name_insured)
                .map(myFormsMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/myforms/{id}")
    public ResponseEntity<MyFormsDTO> updateMyForm(@PathVariable int id, @RequestBody Map<String,Object> update) {
        return myFormsService.updates(id, update)
                .map(myFormsMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/myforms")
    public ResponseEntity<?> createMyForm(@RequestBody MyFormsDTO myFormsDTO) {
        // Validate userId
        if (myFormsDTO.getUser_id() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "User ID is required"));
        }

        // Fetch user
        User user = userService.findById(myFormsDTO.getUser_id().intValue())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "User not found with ID: " + myFormsDTO.getUser_id()
                ));

        // Convert and set user
        MyForms myForm = myFormsMapper.toEntity(myFormsDTO);
        myForm.setUser(user);

        // Save and return
        MyForms savedForm = myFormsService.save(myForm);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(myFormsMapper.toDTO(savedForm));
    }

    @GetMapping("/users/{userId}/myforms")
    public ResponseEntity<List<MyFormsDTO>> getFormsByUser(@PathVariable Long userId) {
        List<MyForms> userForms = myFormsService.findByUserId(userId);
        return ResponseEntity.ok(myFormsMapper.toDTOList(userForms));
    }

}