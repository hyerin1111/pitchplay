package com.kosmo.pitchplay.dto;

import lombok.*;

// 소셜 매칭에 참가한 사용자 정보를 담는 DTO
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String nickname; // 닉네임
    private String profileImg; //프로필이미지

}
