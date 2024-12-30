package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpSession session) {
        // 로그인 서비스 호출 후 성공 시 userId 반환
        return authService.login(userId, password, session);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // 로그인 서비스 호출 후 성공 시 userId 반환
        return authService.logout(session);
    }

    // 이메일 인증번호 발송
    @PostMapping("/send-verification-code")
    public ResponseEntity<String> sendVerificationCode(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        String email = requestBody.get("email");

        return authService.sendVerificationCode(name, email);
    }

    // 인증번호 확인 및 아이디 반환
    @PostMapping("/find-user-id")
    public ResponseEntity<String> findUserId(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        String email = (String) requestBody.get("email");
        Integer verificationCode = (Integer) requestBody.get("verificationCode");

        return authService.findUserId(name, email, verificationCode);
    }
}