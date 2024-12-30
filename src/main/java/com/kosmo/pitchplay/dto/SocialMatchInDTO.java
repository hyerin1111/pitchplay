package com.kosmo.pitchplay.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialMatchInDTO {
    private String userId; // 매칭 생성자 ID
    private String stadiumId; // 경기장 ID
    private String socialGender; // 성별
    private String socialSize; // 매칭 사이즈 (예: "6vs6")
    private String socialLevel; // 실력 수준 (예: "프로")
    private LocalDateTime socialTime; // 경기 시간
    private int totalMember; // 총 참가자 수
    private List<MemberDTO> currentMember; // 초기 참여자 목록
    private Long reservationId;
}

