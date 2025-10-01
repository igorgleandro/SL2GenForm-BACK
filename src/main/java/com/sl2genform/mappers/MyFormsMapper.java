package com.sl2genform.mappers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.entities.MyForms;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyFormsMapper {

    public MyFormsDTO toDTO(MyForms myForms){
        if ( myForms == null){
            return null;
        }
        return MyFormsDTO.builder()
                .agentName(myForms.getAgentName())
                .agentNbr(myForms.getAgentNbr())
                .agencyName(myForms.getAgencyName())
                .agencyNbr(myForms.getAgencyNbr())

                .nameInsured(myForms.getNameInsured())
                .descriptionRisk(myForms.getDescriptionRisk())
                .coverageCode(myForms.getCoverageCode())

                .insurer1(myForms.getInsurer1())
                .contactedThrough1(myForms.getContactedThrough1())
                .fullContactName1(myForms.getFullContactName1())
                .emailPhone1(myForms.getEmailPhone1())
                .website1(myForms.getWebsite1())
                .naic1(myForms.getNaic1())
                .date1(myForms.getDate1())

                .insurer2(myForms.getInsurer2())
                .contactedThrough2(myForms.getContactedThrough2())
                .fullContactName2(myForms.getFullContactName2())
                .emailPhone2(myForms.getEmailPhone2())
                .website2(myForms.getWebsite2())
                .naic2(myForms.getNaic2())
                .date2(myForms.getDate2())

                .insurer3(myForms.getInsurer3())
                .contactedThrough3(myForms.getContactedThrough3())
                .fullContactName3(myForms.getFullContactName3())
                .emailPhone3(myForms.getEmailPhone3())
                .website3(myForms.getWebsite3())
                .naic3(myForms.getNaic3())
                .date3(myForms.getDate3())

                .build();
    }

    public List<MyFormsDTO> toDTOList(List<MyForms> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
