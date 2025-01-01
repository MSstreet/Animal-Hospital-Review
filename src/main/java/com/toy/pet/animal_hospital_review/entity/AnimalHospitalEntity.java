package com.toy.pet.animal_hospital_review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="AnimalHospital")
@Entity
public class AnimalHospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String hospitalName;
    private String hospitalAddr;
    private String hospitalNum;
    private String sigunName;
    private String operState;
    private String zipCode;
    private Double hosLatitude;
    private Double hosLongitude;
}
