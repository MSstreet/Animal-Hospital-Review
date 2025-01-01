package com.toy.pet.animal_hospital_review.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalHospitalEntity, Long> {

}
