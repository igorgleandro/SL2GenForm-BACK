package com.sl2genform.controllers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import com.sl2genform.mappers.MyFormsMapper;
import com.sl2genform.security.UserDetailsImpl;
import com.sl2genform.services.MyFormsService;
import com.sl2genform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://sl2genform-app-production.up.railway.app"})
public class MyFormsController {

    private final MyFormsService myFormsService;
    private final MyFormsMapper myFormsMapper;
    private final UserService userService;

    @GetMapping("/myforms")
    public List<MyFormsDTO> getMyForms(@AuthenticationPrincipal UserDetailsImpl currentUser) {
        return myFormsMapper.toDTOList(myFormsService.findByUserId(currentUser.getId()));
    }

    @GetMapping("/myforms/{id}")
    public ResponseEntity<MyFormsDTO> getMyForms(@PathVariable int id, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        Optional<MyForms> form = myFormsService.getById(id);
        if (form.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!form.get().getUser().getUser_id().equals(currentUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(myFormsMapper.toDTO(form.get()));
    }

    @DeleteMapping("/myforms/{id}")
    public ResponseEntity<Void> deleteMyForms(@PathVariable int id, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        Optional<MyForms> form = myFormsService.getById(id);
        if (form.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!form.get().getUser().getUser_id().equals(currentUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        myFormsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/myforms/name/{name_insured}")
    public ResponseEntity<MyFormsDTO> getByNameInsured(@PathVariable String name_insured, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        Optional<MyForms> form = myFormsService.getByNameInsured(name_insured);
        if (form.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!form.get().getUser().getUser_id().equals(currentUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(myFormsMapper.toDTO(form.get()));
    }

    @PatchMapping("/myforms/{id}")
    public ResponseEntity<MyFormsDTO> updateMyForm(@PathVariable int id, @RequestBody Map<String, Object> update, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        Optional<MyForms> form = myFormsService.getById(id);
        if (form.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!form.get().getUser().getUser_id().equals(currentUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return myFormsService.updates(id, update)
                .map(myFormsMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/myforms")
    public ResponseEntity<?> createMyForm(@Valid @RequestBody MyFormsDTO myFormsDTO, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        // Always use the authenticated user's ID — ignore any user_id in the request body
        User user = userService.findById(currentUser.getId().intValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));

        MyForms myForm = myFormsMapper.toEntity(myFormsDTO);
        myForm.setUser(user);

        MyForms savedForm = myFormsService.save(myForm);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(myFormsMapper.toDTO(savedForm));
    }

    @GetMapping("/users/{userId}/myforms")
    public ResponseEntity<List<MyFormsDTO>> getFormsByUser(@PathVariable Long userId, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        if (!currentUser.getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<MyForms> userForms = myFormsService.findByUserId(userId);
        return ResponseEntity.ok(myFormsMapper.toDTOList(userForms));
    }

}