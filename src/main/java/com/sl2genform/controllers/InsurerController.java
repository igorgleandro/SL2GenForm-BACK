package com.sl2genform.controllers;

import com.sl2genform.dto.InsurerDTO;
import com.sl2genform.entities.Insurer;
import com.sl2genform.mappers.InsurerMapper;
import com.sl2genform.services.InsurerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class InsurerController {

    private final InsurerService insurerService;
    private final InsurerMapper insurerMapper;

    @GetMapping("/insurers")
    public List<InsurerDTO> getInsurers() {
        return insurerMapper.toDTOList((List<Insurer>) insurerService.findAll());
    }
}