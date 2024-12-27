package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Table(name = "TEAM", indexes = {
        @Index(name = "idx_team_code", columnList = "team_code"),
        @Index(name = "idx_team_name", columnList = "team_name"),
        @Index(name = "idx_team_public", columnList = "team_public")
})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "team_id", nullable = false, updatable = false, unique = true, length = 36)
    private String teamId;

    @Column(name = "team_code", nullable = false, updatable = false, unique = true)
    private String teamCode;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "team_leader", nullable = false)
    private String userUid;

    @Column
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
