package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor // 빌더는 기본생성자에 접근을 시도하려고 하나, protected로 막혀있어 접근을 거절당하기 때문에 전체 필드에 대한 생성자를 작성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 값을 넣어야하기 때문에 생성자를 사용, 대신 기본생성자를 추가하되 접근제한을 걸어서 안정성 높임, JPA 받아들일 수 있는 최대 수준의 생성자가 PROTECTED임
@Getter // 엔티티의 경우 일관성 유지를 위해서 @Setter 어노테이션을 붙이지 않는다.
@Entity
@Table(name = "USER",
        indexes = {
                @Index(name="idx_user_number", columnList = "user_number"),
                @Index(name="idx_email", columnList = "email"),
                @Index(name="idx_id", columnList = "id"),
                @Index(name="idx_nickname", columnList = "nickname"),
                @Index(name="idx_join_date", columnList = "join_date")
        })
@Builder(toBuilder = true) // 빌더 패턴 사용
public class User {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.UUID) // 자동으로 UUID가 생성됨
    @Column(name = "user_uid", nullable = false, updatable = false, unique = true, length = 36)
    // null값 비허용, 수정 비허용, 유일한 값, 길이는 36
    private String userUid;

    @Column(name = "user_number", nullable = false, updatable = false, unique = true)
    // 자동으로 생성되는 6자리 유저번호, 프론트에서 uid말고 유저번호 사용 예정
    private Integer userNumber;

    // 필수정보
    @Column(name = "name", nullable = false, length = 20)
    private String name; // 성명

    @Column(name = "birthday", nullable = false, length = 20)
    private String birthday; // 생년월일 (재설정 가능)

    @Column(name = "phone", nullable = false, length = 20)
    private String phone; // 휴대폰 번호(재설정 가능)

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; // 이메일 (재설정 가능)

    @Column(name = "id", nullable = false, unique = true, length = 15)
    private String id; // 아이디

    @Column(name = "nickname", unique = true, length = 20)
    private String nickname; // 닉네임

    @Column(name = "password", nullable = false, length = 60)
    private String password; // 비밀번호

    // 프로필 정보
    @Column(name = "profile_img")
    private String profileImg;  // http://localhost:8080/프로필이미지.jpg 이런식으로 저장될 예정

    @Column(name = "favorite_city", length = 150)
    @Size(max = 100, message = "선호하는 도시 정보는 100자를 넘을 수 없습니다.")
    private String favoriteCity;

    @Column(name = "favorite_time", length = 150)
    @Size(max = 100, message = "선호하는 시간대 정보는 100자를 넘을 수 없습니다.")
    private String favoriteTime;

    @Column(name = "my_team")
    private String myTeam;

    @Column(name = "my_description", length = 150)
    @Size(max = 100, message = "자기소개는 100자를 넘을 수 없습니다.")
    private String myDescription;

    @Column(name = "user_cash")
    private Integer userCash;

    // 개인 정보
    @Column(name = "account")
    private String account; // 은행명

    @Column(name = "account_num")
    private String accountNum; // 은행계좌번호

    @Column(name = "profile_public", nullable = false)
    private Boolean profilePublic = true; // 프로필 공개설정 (기본값 true)

    @Column(name = "email_notification", nullable = false)
    private Boolean emailNotification = false;  // 이메일 알림설정(기본값 false)

    @Column(name = "sns_notification", nullable = false)
    private Boolean snsNotification = false;  // SNS 알림설정 (기본값 false)

    @Column(name = "join_date", nullable = false)
    private LocalDateTime joinDate = LocalDateTime.now(); // 가입날짜 (기본값 현재시간)

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;  // 탈퇴여부
}
