package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "SOCIAL_MATCH")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialMatch {
    @Id
    @Column(name = "social_match_id", nullable = false, updatable = false)
    private String matchId;

    @Column(name = "match_number", unique = true, nullable = false)
    private Integer matchNumber; // 6자리 숫자

    @Column(name = "written_date", nullable = false)
    private LocalDateTime writtenDate;


    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false) // 외래 키 매핑
    private Reservation reservation; // Reservation 엔티티와 관계 설정

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "stadium_id", nullable = false)
    private String stadiumId;

    @Column(name = "social_gender", nullable = false)
    private String socialGender;

    @Column(name = "social_size", nullable = false)
    private String socialSize;

    @Column(name = "social_level", nullable = false)
    private String socialLevel;

    @Column(name = "social_time", nullable = false)
    private LocalDateTime socialTime;

    @ElementCollection
    @CollectionTable(name = "SOCIAL_MATCH_MEMBERS", joinColumns = @JoinColumn(name = "social_match_id"))
    @Column(name = "member_nickname")
    private List<Member> currentMember;

    @Column(name = "total_member", nullable = false)
    private Integer totalMember;

    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;
}
