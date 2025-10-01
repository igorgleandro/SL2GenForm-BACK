package com.sl2genform.controllers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.mappers.MyFormsMapper;
import com.sl2genform.services.MyFormsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MyFormsController {

    private final MyFormsService myFormsService;
    private final MyFormsMapper myFormsMapper;

    @GetMapping("/myforms")
    public List<MyFormsDTO> getMyForms() {
        return myFormsMapper.toDTOList((List<MyForms>) myFormsService.getAll());
    }
}
