package com.kosmo.pitchplay.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class TeamInDTO {

    private String teamCode;
    private String teamName;
    private String userUid;
    private String teamLevel;
    private String teamRegion;
    private List<String> teamPlayDay;
    private List<String> teamPlayTime;
    private String teamImageUrl;
    private List<String> teamMember;
    @Size(max = 30, message = "팀원은 최대 30명까지 입니다.")
    private Integer teamMemberCount;
    private String teamIntroduce;
    private String teamByAge;
    private String stadiumName;
    private Boolean teamPublic;
}
