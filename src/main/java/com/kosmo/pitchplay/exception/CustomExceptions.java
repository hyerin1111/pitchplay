package com.kosmo.pitchplay.exception;

public class CustomExceptions {

    //중복 예외
    public static class DuplicateException extends RuntimeException {
        public DuplicateException(String message) {
            super(message);
        }
    }

    // 불일치 예외
    public static class InvalidException extends RuntimeException {
        public InvalidException(String message) {
            super(message);
        }
    }

    // 유저 없음 예외
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(){
            super("유저를 찾을 수 없습니다.");
        }
    }



}
