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

    // 이메일 인증번호 발송(회원가입 시에)
    @PostMapping("/send-email")
    public ResponseEntity<String> sendRegisterVerificationCode(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");

        return authService.sendVerificationCode(email, null, null);
    }

    // 아이디 인증번호 발송
    @PostMapping("/verify-id-code")
    public ResponseEntity<String> sendVerificationCode(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String name = requestBody.get("name");
        return authService.sendVerificationCode(email, name, null);
    }

    // 비밀번호 찾기 (인증번호 발송)
    @PostMapping("/verify-password-code")
    public ResponseEntity<String> findPassword(@RequestBody Map<String, String> requestBody) {
        String email = (String) requestBody.get("email");
        String name = (String) requestBody.get("name");
        String userId = (String) requestBody.get("userId");

        return authService.sendVerificationCode(email, name, userId);
    }

    // 아이디 인증번호 확인 및 아이디 반환
    @PostMapping("/find-user-id")
    public ResponseEntity<String> findUserId(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String name = (String) requestBody.get("name");
        Integer verificationCode = (Integer) requestBody.get("verificationCode");

        return authService.findUserId(name, email, verificationCode);
    }

    // 인증번호 확인 (회원가입 시 인증번호 & 비밀번호 재설정 시 인증번호)
    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Integer verificationCode = (Integer) requestBody.get("verificationCode");

        return authService.verifyCode(email, verificationCode);
    }

    // 비밀번호 재설정
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String newPassword = requestBody.get("newPassword");

        return authService.resetPassword(email, newPassword);
    }

}