package com.kosmo.pitchplay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String nickname; // 닉네임

    @Column(name = "social_profile_img") // 테이블에서 열 이름 설정
    private String profileImg; // 기존 src에서 profileImg로 변경
}
