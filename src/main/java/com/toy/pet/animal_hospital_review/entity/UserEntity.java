package com.toy.pet.animal_hospital_review.entity;

import com.toy.pet.animal_hospital_review.web.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Setter
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
    @ColumnDefault("false") //default 0
    private boolean deleteYn;

    public static UserEntity toEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserPw(userDto.getUserPw());
        userEntity.setUserPwChk(userDto.getUserPwChk());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setUserEmail(userDto.getUserEmail());
        userEntity.setUserAddress(userDto.getUserAddress());
        userEntity.setUserAddressDtl(userDto.getUserAddressDtl());
        userEntity.setUserZipCode(userDto.getUserZipCode());
        return userEntity;
    }
}
