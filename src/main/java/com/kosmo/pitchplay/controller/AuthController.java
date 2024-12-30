package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

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
}