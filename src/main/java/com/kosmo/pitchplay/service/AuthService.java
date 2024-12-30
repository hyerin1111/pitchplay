package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.entity.User;
import com.kosmo.pitchplay.repository.UserRepository;
import com.kosmo.pitchplay.exception.CustomExceptions.UserNotFoundException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kosmo.pitchplay.exception.CustomExceptions.*;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 로그인
    public ResponseEntity<String> login(String userId, String password, HttpSession session) {
        // userId로 사용자 조회
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException());

        // 비밀번호 확인 (암호화된 비밀번호와 입력한 비밀번호 비교)
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidException("비밀번호가 일치하지 않습니다.");
        }

        // 로그인 성공 시, session에 userUid 저장
        session.setAttribute("userUid", user.getUserUid()); // 세션에 userId 저장


        return ResponseEntity.ok("로그인에 성공하셨습니다.");
    }
}