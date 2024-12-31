package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
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

    @Column(name = "team_play_day", columnDefinition = "TEXT") // JSON 데이터로 저장
    private List<String> teamPlayDay;

    @Column(name = "team_play_time", columnDefinition = "TEXT")
    private List<String> teamPlayTime;

    @Column(name = "team_member", columnDefinition = "TEXT")
    private List<String> teamMember;

    @Column
    private String teamLevel;
    private String teamRegion;
    private String teamImageUrl;
    private Integer teamMemberCount;
    private String teamIntroduce;
    private String teamByAge;
    private String stadiumName;
    private Boolean teamPublic;

}
