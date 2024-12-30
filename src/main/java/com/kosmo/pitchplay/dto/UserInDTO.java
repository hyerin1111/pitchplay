package com.kosmo.pitchplay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInDTO {
    // 필수정보
    @NotNull(message = "이름은 필수입니다.")
    private String name; // 성명

    @NotNull(message = "생년월일은 필수입니다.")
    private String birthday; // 생년월일

    @NotNull(message = "휴대폰 번호는 필수입니다.")
    private String phone; // 휴대폰 번호

    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String email; // 이메일

    @NotNull(message = "아이디는 필수입니다.")
    private String id; // 아이디

    private String nickname; // 닉네임

    @NotNull(message = "비밀번호는 필수입니다.")
    private String password; // 비밀번호

    // 프로필정보
    private String profileImg; // 프로필 이미지

    @Size(max = 100, message = "선호하는 도시는 100자를 넘을 수 없습니다.")
    private String favoriteCity; // 선호하는 도시

    @Size(max = 100, message = "선호하는 시간대는 100자를 넘을 수 없습니다.")
    private String favoriteTime; // 선호하는 시간대

    @Size(max = 100, message = "자기소개는 100자를 넘을 수 없습니다.")
    private String myDescription; // 자기소개글

    // 개인정보
    private String account; // 은행명

    @Pattern(regexp = "^[0-9]+$", message = "계좌번호는 숫자만 포함해야 합니다.")
    private String accountNum; // 은행 계좌번호

    private Boolean profilePublic; // 프로필 공개 여부
    private Boolean emailNotification; // 이메일 알림 설정
    private Boolean snsNotification; // SNS 알림 설정
}
