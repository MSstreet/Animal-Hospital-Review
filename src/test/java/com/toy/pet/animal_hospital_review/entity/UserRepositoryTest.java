package com.toy.pet.animal_hospital_review.entity;

import com.toy.pet.animal_hospital_review.AnimalHospitalReviewApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("1. 유저 데이터 생성하기")
    @Test
    void test_1(){
        String encPassword = passwordEncoder.encode("test_password");
        UserEntity userEntity = UserEntity.builder()
                .userId("test_user")
                .userPw(encPassword)
                .userName("테스트유저")
                .build();

        UserEntity savedUser = userRepository.save(userEntity);
        assertThat(userEntity.getUserId()).isEqualTo(savedUser.getUserId());
    }
}