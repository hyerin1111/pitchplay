package com.kosmo.pitchplay.exception;

public class CustomExceptions {

    //중복 예외
    public static class DuplicateException extends RuntimeException {
        public DuplicateException(String message) {
            super(message);
        }
    }


    // 인증번호 불일치 예외
    public static class InvalidVerificationCodeException extends RuntimeException {
        public InvalidVerificationCodeException(String message) {
            super(message);
        }
    }

    // 유저 미발견 예외
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(){
            super("유저를 찾을 수 없습니다.");
        }
    }


}
