package com.sl2genform.mappers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.entities.MyForms;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyFormsMapper {

    public MyFormsDTO toDTO(MyForms myForms){
        if (myForms == null){
            return null;
        }
        return MyFormsDTO.builder()
                .id(myForms.getId())
                .user_id(myForms.getUser() != null ? myForms.getUser().getUser_id() : null)

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

    public List<MyFormsDTO> toDTOList(List<MyForms> myForms) {
        return myForms.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public MyForms toEntity(MyFormsDTO myFormsDTO) {
        if (myFormsDTO == null) {
            return null;
        }
        return MyForms.builder()

                .agentName(myFormsDTO.getAgentName())
                .agentNbr(myFormsDTO.getAgentNbr())
                .agencyName(myFormsDTO.getAgencyName())
                .agencyNbr(myFormsDTO.getAgencyNbr())

                .nameInsured(myFormsDTO.getNameInsured())
                .descriptionRisk(myFormsDTO.getDescriptionRisk())
                .coverageCode(myFormsDTO.getCoverageCode())

                .insurer1(myFormsDTO.getInsurer1())
                .contactedThrough1(myFormsDTO.getContactedThrough1())
                .fullContactName1(myFormsDTO.getFullContactName1())
                .emailPhone1(myFormsDTO.getEmailPhone1())
                .website1(myFormsDTO.getWebsite1())
                .naic1(myFormsDTO.getNaic1())
                .date1(myFormsDTO.getDate1())

                .insurer2(myFormsDTO.getInsurer2())
                .contactedThrough2(myFormsDTO.getContactedThrough2())
                .fullContactName2(myFormsDTO.getFullContactName2())
                .emailPhone2(myFormsDTO.getEmailPhone2())
                .website2(myFormsDTO.getWebsite2())
                .naic2(myFormsDTO.getNaic2())
                .date2(myFormsDTO.getDate2())

                .insurer3(myFormsDTO.getInsurer3())
                .contactedThrough3(myFormsDTO.getContactedThrough3())
                .fullContactName3(myFormsDTO.getFullContactName3())
                .emailPhone3(myFormsDTO.getEmailPhone3())
                .website3(myFormsDTO.getWebsite3())
                .naic3(myFormsDTO.getNaic3())
                .date3(myFormsDTO.getDate3())

                .build();
    }
}