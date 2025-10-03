package com.sl2genform.controllers;


import com.sl2genform.dto.CovCodeDTO;
import com.sl2genform.entities.CovCode;
import com.sl2genform.mappers.CovCodeMapper;
import com.sl2genform.services.CovCodeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CovCodeController {
    private final CovCodeService covCodeService;
    private final CovCodeMapper covCodeMapper;

    @GetMapping("/covcode")
    public List<CovCodeDTO> getCovCode() {
        return covCodeMapper.toDTOList((List<CovCode>) covCodeService.findAll());
    }
}