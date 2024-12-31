package com.toy.pet.animal_hospital_review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ReviewEntity {

    @Id
    private Long idx;
    private String title;
    private String content;
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private AnimalHospital petHospitalEntity;
}
