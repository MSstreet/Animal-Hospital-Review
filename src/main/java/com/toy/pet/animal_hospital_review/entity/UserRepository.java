package com.toy.pet.animal_hospital_review.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
