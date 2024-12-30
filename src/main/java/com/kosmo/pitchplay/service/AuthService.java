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

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    private final Map<String, Integer> verificationCodes = new HashMap<>(); // 이메일 인증번호 저장

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

    // 로그아웃
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

    // 이메일인증
    public ResponseEntity<String> sendVerificationCode(String name, String email) {
        // 이름과 이메일로 사용자 찾기
        User user = userRepository.findByNameAndEmail(name, email)
                .orElseThrow(() -> new UserNotFoundException());

        // 인증번호 발송
        Integer verificationCode = emailService.sendMail(email);  // 이메일로 인증번호 발송

        // 인증번호 저장
        verificationCodes.put(email, verificationCode);

        return ResponseEntity.ok("인증번호가 이메일로 발송되었습니다.");
    }

    // 인증번호 확인 후 아이디 반환
    public ResponseEntity<String> findUserId(String name, String email, Integer verificationCode) {
        // 이메일로 저장된 인증번호 검증
        Integer storedCode = verificationCodes.get(email);
        if (storedCode == null || !storedCode.equals(verificationCode)) {
            throw new InvalidException("인증번호가 일치하지 않습니다.");
        }

        // 이름과 이메일로 사용자 조회
        User user = userRepository.findByNameAndEmail(name, email)
                .orElseThrow(() -> new UserNotFoundException());

        // 인증번호가 맞으면 아이디 반환
        return ResponseEntity.ok("아이디는 " + user.getUserId() + "입니다.");
    }

    // 비밀번호 찾기
    public ResponseEntity<String> findPassword(String name, String userId, String email) {
        // 이름, 아이디, 이메일로 사용자 조회
        User user = userRepository.findByNameAndUserIdAndEmail(name, userId, email)
                .orElseThrow(() -> new UserNotFoundException());

        // 인증번호 발송
        Integer verificationCode = emailService.sendMail(email);  // 이메일로 인증번호 발송

        // 인증번호 저장
        verificationCodes.put(email, verificationCode);

        return ResponseEntity.ok("인증번호가 이메일로 발송되었습니다.");
    }

    // 비밀번호 인증
    public ResponseEntity<String> verifyPasswordCode(String email, Integer verificationCode) {
        // 이메일로 저장된 인증번호 검증
        Integer storedCode = verificationCodes.get(email);
        if (storedCode == null || !storedCode.equals(verificationCode)) {
            throw new InvalidException("인증번호가 일치하지 않습니다.");
        }

        return ResponseEntity.ok("인증번호가 확인되었습니다. 새로운 비밀번호를 설정해주세요.");
    }

    // 비밀번호 재설정
    public ResponseEntity<String> resetPassword(String name, String userId, String email, Integer verificationCode, String newPassword) {
        // 이메일로 저장된 인증번호 검증
        Integer storedCode = verificationCodes.get(email);
        if (storedCode == null || !storedCode.equals(verificationCode)) {
            throw new InvalidException("인증번호가 일치하지 않습니다.");
        }

        // 이름, 아이디, 이메일로 사용자 조회
        User user = userRepository.findByNameAndUserIdAndEmail(name, userId, email)
                .orElseThrow(() -> new UserNotFoundException());

        // 새 비밀번호 암호화
        user = user.toBuilder()
                .password(passwordEncoder.encode(newPassword)) // 비밀번호를 암호화하여 설정
                .build();

        // 비밀번호 업데이트
        userRepository.save(user);

        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
    }
}