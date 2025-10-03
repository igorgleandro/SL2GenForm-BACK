package com.sl2genform.mappers;

import com.sl2genform.dto.InsurerDTO;
import com.sl2genform.entities.Insurer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InsurerMapper {

          public InsurerDTO toDTO(Insurer insurer) {

            if (insurer == null) {
                return null;
            }


            return  InsurerDTO.builder()
                    .id((long) insurer.getId())
                    .insurer (insurer.getInsurer ())
                    .naic (insurer.getNaic())
                    .website(insurer.getWebsite())
                    .build();

        }

        public List<InsurerDTO> toDTOList(List<Insurer> insurers) {
            return insurers.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
    }

