package com.toy.pet.animal_hospital_review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class WebSecurityConfig {


    // PasswordEncoder Bean 설정
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager Bean 설정 (Spring Security 5 이상에서는 명시적으로 선언해야 함)
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    // SecurityFilterChain을 사용한 보안 설정 (WebSecurityConfigurerAdapter 대체)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)  // CSRF 보호 비활성화
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // 모든 요청을 허용
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 세션 관리 정책을 STATELESS로 설정
                )
                .formLogin(AbstractHttpConfigurer::disable  // 폼 로그인 비활성화
                )
                .cors(AbstractHttpConfigurer::disable);  // CORS 활성화

        // .addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class); // 필터 추가는 필요에 따라 활성화
        return null;
    }

}
