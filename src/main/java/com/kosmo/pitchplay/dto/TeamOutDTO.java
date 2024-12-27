package com.kosmo.pitchplay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
public class TeamOutDTO {

    private String teamCode;
    @NotBlank(message = "팀 이름은 반드시 입력해야 합니다.")
    private String teamName;
    private String userUid;
    private String teamLevel;
    private String teamRegion;
    private List<String> teamPlayDay;
    private List<LocalTime> teamPlayTime;
    private String teamImageUrl;
    private List<String> teamMember;
    @Size(max = 30, message = "팀원은 최대 30명까지 입니다.")
    private Integer teamMemberCount;
    private String teamIntroduce;
    private String teamByAge;
    private String stadiumName;
    private Boolean teamPublic;
}
