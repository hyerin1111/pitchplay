package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.dto.UserInDTO;
import com.kosmo.pitchplay.dto.UserOutDTO;
import com.kosmo.pitchplay.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입(Create)
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserInDTO userInDTO){
        userService.registerUser(userInDTO);
        return ResponseEntity.ok("회원가입에 성공하셨습니다.");
    }

    // 회원정보불러오기(Read)
    @GetMapping
    public ResponseEntity<UserOutDTO> getUserByUserUid(HttpSession session) {
        UserOutDTO user = userService.getUserByUserUid(session);
        return ResponseEntity.ok(user);
    }

    // 회원정보수정(Update)
    @PatchMapping
    public ResponseEntity<UserOutDTO> updateUser(HttpSession session, @RequestBody UserInDTO userInDTO) {
        // 회원정보 수정 처리
        UserOutDTO updatedUser = userService.updateUser(session, userInDTO);

        return ResponseEntity.ok(updatedUser);  // 수정된 정보 반환
    }

    // 회원탈퇴(Delete)
    @DeleteMapping
    public ResponseEntity<String> deleteUser(HttpSession session) {
        // 회원탈퇴 처리
        userService.deleteUser(session);

        // 탈퇴 완료 메시지 반환
        return ResponseEntity.ok("탈퇴가 완료되었습니다.");
    }
}
