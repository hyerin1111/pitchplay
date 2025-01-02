package com.kosmo.pitchplay.entity;

import com.kosmo.pitchplay.converter.StringListConverter;
import com.kosmo.pitchplay.enums.TeamRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Convert(converter = StringListConverter.class)
    @Column(name = "team_play_day", columnDefinition = "TEXT")
    private List<String> teamPlayDay;

    @Convert(converter = StringListConverter.class)
    @Column(name = "team_play_time", columnDefinition = "TEXT")
    private List<String> teamPlayTime;

    @Convert(converter = StringListConverter.class)
    @Column(name = "team_member", columnDefinition = "LONGTEXT")
    private List<String> teamMember;

    // 사용자 UID와 역할 매핑
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "team_members", joinColumns = @JoinColumn(name = "team_id"))
    @MapKeyColumn(name = "user_uid")
    @Column(name = "team_role")
    @Enumerated(EnumType.STRING)
    private Map<String, TeamRole> teamMembers = new HashMap<>();

    // 가입 대기 목록
    @Convert(converter = StringListConverter.class)
    @Column(name = "pending_members", columnDefinition = "TEXT")
    private List<String> pendingMembers;

    @Column
    private String teamLevel;
    private String teamRegion;
    private String teamImageUrl;
    private Integer teamMemberCount;
    private String teamIntroduce;
    private String teamByAge;
    private String stadiumName;
    private Boolean teamPublic;


    // 편의 메서드 추가
    public void addMember(String userUid, TeamRole role) {
        this.teamMembers.put(userUid, role);
    }

    public void removeMember(String userUid) {
        this.teamMembers.remove(userUid);
    }

    public void addPendingMember(String userUid) {
        if (!this.pendingMembers.contains(userUid)) {
            this.pendingMembers.add(userUid); // 대기 목록에 사용자 추가
        }
    }

    public void removePendingMember(String userUid) {
        this.pendingMembers.remove(userUid); // 대기 목록에서 사용자 제거
    }

}
