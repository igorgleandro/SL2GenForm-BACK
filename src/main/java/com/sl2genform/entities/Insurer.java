package com.sl2genform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "insurers")
public class Insurer {

    @Id
    @Column(name = "id", length = 50)
    private int id;

    @Column(name = "insurer", nullable = false)
    private String insurer;

    @Column(name = "naic")
    private String naic;

    @Column(name = "website", length = 500)
    private String website;

}
