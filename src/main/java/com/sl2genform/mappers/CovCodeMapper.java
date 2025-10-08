package com.sl2genform.mappers;


import com.sl2genform.dto.CovCodeDTO;
import com.sl2genform.entities.CovCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CovCodeMapper {

    public CovCodeDTO toDTO(CovCode covCode) {

        if (covCode == null) {
            return null;
        }


        return  CovCodeDTO.builder()
                .id((long) covCode.getId())
                .code (covCode.getCode ())
                .name(covCode.getName())
                .build();

    }

    public List<CovCodeDTO> toDTOList(List<CovCode> covCode) {
        return covCode.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


}
