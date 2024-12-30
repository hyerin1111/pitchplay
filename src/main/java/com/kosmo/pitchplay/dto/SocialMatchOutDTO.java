package com.kosmo.pitchplay.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialMatchOutDTO {
    private String matchId; // 매칭 ID
    private Integer matchNumber; // 6자리 숫자
    private String userId; // 생성자 ID
    private String nickname; // 생성자 닉네임
    private String stadiumId; // 경기장 ID
    private String socialGender; // 성별
    private String socialSize; // 매칭 사이즈
    private String socialLevel; // 실력 수준
    private LocalDateTime socialTime; // 경기 시간
    private int totalMember; // 총 참가자 수
    private List<MemberDTO> currentMember; // 현재 참여자 목록
    private boolean activeStatus; // 활성화 상태
    private int viewCount; // 조회수

}
