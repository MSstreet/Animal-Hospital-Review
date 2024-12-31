package com.toy.pet.animal_hospital_review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AnimalHospital {

    @Id
    private Long hospitalIdx;
    private String hospitalName;
    private String hospitalAddr;
    private String hospitalNum;
    private String sigunName;
    private String operState;
    private String zipCode;
    private String hosLatitude;
    private String hosLongitude;
}
