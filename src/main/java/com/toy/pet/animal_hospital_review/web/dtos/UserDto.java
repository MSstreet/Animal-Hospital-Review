package com.toy.pet.animal_hospital_review.web.dtos;

import com.toy.pet.animal_hospital_review.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private Long idx;
    private String userId;
    private String userPw;
    private String userPwChk;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userAddressDtl;
    private String userZipCode;
    private boolean deleteYn;


}
