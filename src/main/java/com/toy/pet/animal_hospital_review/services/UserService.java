package com.toy.pet.animal_hospital_review.services;

import com.toy.pet.animal_hospital_review.entity.UserEntity;
import com.toy.pet.animal_hospital_review.entity.UserRepository;
import com.toy.pet.animal_hospital_review.web.dtos.UserDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserEntity userEntity = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (userEntity.getUserId().equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return new User(userEntity.getUserId(), userEntity.getUserPw(), authorities);
    }

    @Transactional
    public UserEntity saveUser(@Valid UserDto userDto) {
        return userRepository.save(UserEntity.toEntity(userDto));
    }
}
