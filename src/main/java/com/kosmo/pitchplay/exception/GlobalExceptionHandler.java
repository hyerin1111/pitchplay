package com.kosmo.pitchplay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 모든 컨트롤러에서 발생하는 예외를 한 곳에서 처리 (controller에서 try catch문 사용 없이 해당하는 HTTP 상태에 따른 응답 반환함)
@ControllerAdvice
public class GlobalExceptionHandler {
    // 중복 예외 처리
    @ExceptionHandler(CustomExceptions.DuplicateException.class)
    public ResponseEntity<String> handleDuplicateEmailException(CustomExceptions.DuplicateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // 인증번호 불일치 예외 처리
    @ExceptionHandler(CustomExceptions.InvalidException.class)
    public ResponseEntity<String> handleInvalidVerificationCodeException(CustomExceptions.InvalidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // 유저 미발견 예외 처리
    @ExceptionHandler(CustomExceptions.UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(CustomExceptions.UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    // 모든 기타 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류입니다.");
    }
}
