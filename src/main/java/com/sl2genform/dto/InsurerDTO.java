package com.sl2genform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsurerDTO {
        private String id;
        private String name;
        private String insurer;
        private String naic;
        private String website;
    }

