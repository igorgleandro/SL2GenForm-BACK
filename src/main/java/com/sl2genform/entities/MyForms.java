package com.sl2genform.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "myforms" )
public class MyForms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "agentName")
    private String agentName;
    @Column(name = "agentNbr")
    private String agentNbr;
    @Column(name = "agencyName")
    private String agencyName;
    @Column(name = "agencyNbr")
    private String agencyNbr;


    @Column(name = "nameInsured")
    private String nameInsured;
    @Column(name = "descriptionRisk")
    private String descriptionRisk;
    @Column(name = "coverageCode")
    private String coverageCode;


    @Column(name = "insurer1")
    private String insurer1;
    @Column(name = "contactedThrough1")
    private String contactedThrough1;
    @Column(name = "fullContactName1")
    private String fullContactName1;
    @Column(name = "emailPhone1")
    private String emailPhone1;
    @Column(name = "website1")
    private String website1;
    @Column(name = "naic1")
    private String naic1;
    @Column(name = "date1")
    private String date1;


    @Column(name = "insurer2")
    private String insurer2;
    @Column(name = "contactedThrough2")
    private String contactedThrough2;
    @Column(name = "fullContactName2")
    private String fullContactName2;
    @Column(name = "emailPhone2")
    private String emailPhone2;
    @Column(name = "website2")
    private String website2;
    @Column(name = "naic2")
    private String naic2;
    @Column(name = "date2")
    private String date2;


    @Column(name = "insurer3")
    private String insurer3;
    @Column(name = "contactedThrough3")
    private String contactedThrough3;
    @Column(name = "fullContactName3")
    private String fullContactName3;
    @Column(name = "emailPhone3")
    private String emailPhone3;
    @Column(name = "website3")
    private String website3;
    @Column(name = "naic3")
    private String naic3;
    @Column(name = "date3")
    private String date3;

}
