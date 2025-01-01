package com.toy.pet.animal_hospital_review.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="USER")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String userId;
    private String userPw;
    private String userPwChk;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userAddressDtl;
    private String userZipCode;
}
