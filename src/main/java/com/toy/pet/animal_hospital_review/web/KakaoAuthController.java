package com.toy.pet.animal_hospital_review.web;

import com.toy.pet.animal_hospital_review.services.KakaoAuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth/kakao")
public class KakaoAuthController {

    private final KakaoAuthService kakaoAuthService;
//    @Value("${security.oauth2.client.registration.kakao.client-id}")
//    private String CLIENT_ID;

//    @Value("${security.oauth2.client.registration.kakao.redirect-uri}")
//    private String REDIRECT_URI;

    private static final String CLIENT_ID = "409b3fb04dd78999f86c8dbc4a19372a"; // 카카오 REST API 키
    private static final String REDIRECT_URI = "http://localhost:8081/oauth/kakao/callback"; // 리디렉션 URI

    @GetMapping("/login-url")
    public String getKakaoLoginUrl() {
        String authorizationUri = String.format(
                "https://kauth.kakao.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code",
                CLIENT_ID, REDIRECT_URI
        );
        return authorizationUri;
    }

    @GetMapping("/callback")
    public void kakaoCallback(@RequestParam String code, HttpServletResponse response) throws IOException {
        // KakaoAuthService에서 액세스 토큰을 받아옵니다.
        String accessToken = kakaoAuthService.getKakaoAccessToken(code);

        // 액세스 토큰을 사용하여 사용자 정보 가져오기
        Map<String, Object> userInfo = kakaoAuthService.getUserInfo(accessToken);

        // 사용자 정보를 URL 파라미터로 변환
        String userId = (String) userInfo.get("id");
        String email = (String) ((Map<String, Object>) userInfo.get("kakao_account")).get("email");
        String nickname = (String) ((Map<String, Object>) userInfo.get("properties")).get("nickname");

        // 리디렉션 URL 지정 (사용자 정보를 쿼리 파라미터로 포함)
        String redirectUrl = String.format("http://localhost:8080/?userId=%s&email=%s&nickname=%s",
                userId, email, nickname);

        // 리디렉션 처리
        response.sendRedirect(redirectUrl);
    }

//    @GetMapping("/callback")
//    public ResponseEntity<String> kakaoCallback(@RequestParam String code) {
//        String accessToken = kakaoAuthService.getKakaoAccessToken(code);
//        // 액세스 토큰을 이용해 사용자 정보 가져오기
//        Map<String, Object> userInfo = kakaoAuthService.getUserInfo(accessToken);
//
//        // 사용자 정보 반환 또는 로그인 처리
//        return ResponseEntity.ok("Kakao Login Success: " + userInfo);
//    }
}
