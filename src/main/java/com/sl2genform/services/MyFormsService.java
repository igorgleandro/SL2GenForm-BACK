package com.sl2genform.services;

import com.sl2genform.entities.MyForms;
import com.sl2genform.repositories.MyFormsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyFormsService {

    MyFormsRepository myFormsRepository;

    public MyForms save(MyForms myForm) {
        System.out.println("Saving form....");
        myFormsRepository.save(myForm);
        System.out.println("...Saved");

        return myForm;
    }

    public Iterable<MyForms> getAll(){
        return myFormsRepository.findAll();
    }

    public void deleteById(Integer id){
        myFormsRepository.deleteById(id);
    }

    public Optional<MyForms> getById(Integer id){
        return myFormsRepository.findById(id);
    }

    public Optional<MyForms> getByNameInsured(String name_insured){
        return myFormsRepository.getByNameInsured(name_insured);
    }

    public List<MyForms> findByUserId(Long userId) {
        return myFormsRepository.findByUserUserId(userId);
    }

    public Optional<MyForms> updates(int id, Map<String,Object> updates){
        return myFormsRepository.findById(id)
                .map(myForms -> {
                    updates.forEach((key,value)->{
                        switch (key){
                            case "agentName" -> myForms.setAgentName((String)value);
                            case "agentNbr" -> myForms.setAgentNbr((String)value);
                            case "agencyName" -> myForms.setAgencyName((String)value);
                            case "agencyNbr" -> myForms.setAgencyNbr((String)value);

                            case "nameInsured" -> myForms.setNameInsured((String)value);
                            case "descriptionRisk" -> myForms.setDescriptionRisk((String)value);
                            case "coverageCode"  -> myForms.setCoverageCode((String)value);

                            case "insurer1" -> myForms.setInsurer1((String)value);
                            case "contactedThrough1" -> myForms.setContactedThrough1((String)value);
                            case "fullContactName1" -> myForms.setFullContactName1((String)value);
                            case "emailPhone1" -> myForms.setEmailPhone1((String)value);
                            case "website1" -> myForms.setWebsite1((String)value);
                            case "naic1" -> myForms.setNaic1((String)value);
                            case "date1" -> myForms.setDate1((String)value);

                            case "insurer2" -> myForms.setInsurer2((String)value);
                            case "contactedThrough2" -> myForms.setContactedThrough2((String)value);
                            case "fullContactName2" -> myForms.setFullContactName2((String)value);
                            case "emailPhone2" -> myForms.setEmailPhone2((String)value);
                            case "website2" -> myForms.setWebsite2((String)value);
                            case "naic2" -> myForms.setNaic2((String)value);
                            case "date2" -> myForms.setDate2((String)value);

                            case "insurer3" -> myForms.setInsurer3((String)value);
                            case "contactedThrough3" -> myForms.setContactedThrough3((String)value);
                            case "fullContactName3" -> myForms.setFullContactName3((String)value);
                            case "emailPhone3" -> myForms.setEmailPhone3((String)value);
                            case "website3" -> myForms.setWebsite3((String)value);
                            case "naic3" -> myForms.setNaic3((String)value);
                            case "date3" -> myForms.setDate3((String)value);
                        }
                    });
                    return myFormsRepository.save(myForms);
                });
    }
}