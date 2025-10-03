package com.sl2genform.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyFormsDTO {

    private Integer id;
    private Long userId;

    private String agentName;
    private String agentNbr;
    private String agencyName;
    private String agencyNbr;

    private String nameInsured;
    private String descriptionRisk;
    private String coverageCode;

    private String insurer1;
    private String contactedThrough1;
    private String fullContactName1;
    private String emailPhone1;
    private String website1;
    private String naic1;
    private String date1;

    private String insurer2;
    private String contactedThrough2;
    private String fullContactName2;
    private String emailPhone2;
    private String website2;
    private String naic2;
    private String date2;

    private String insurer3;
    private String contactedThrough3;
    private String fullContactName3;
    private String emailPhone3;
    private String website3;
    private String naic3;
    private String date3;

}
