package com.kosmo.pitchplay.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInDTO {
    //필수정보
    private String name; //성명
    private String birthday; // 생년월일
    private String phone; // 휴대폰 번호
    private String email; // 이메일
    private String id; //아이디
    private String nickname; // 닉네임
    private String password; // 비밀번호

    //프로필정보
    private String profileImg; //프로필이미지
    @Size(max = 100, message = "선호하는 도시 정보는 100자를 넘을 수 없습니다.")
    private String favoriteCity; // 선호하는 도시
    @Size(max = 100, message = "선호하는 시간대 정보는 100자를 넘을 수 없습니다.")
    private String favoriteTime; // 선호하는 시간대
    @Size(max = 100, message = "자기소개는 100자를 넘을 수 없습니다.")
    private String myDescription; //자기소개글

    //개인정보
    private String account; //은행명
    private String accountNum; //은행계좌번호

    private Boolean profilePublic; // 프로필 공개 여부
    private Boolean emailNotification; // 이메일 알림설정
    private Boolean snsNotification; // SNS 알림설정
}
