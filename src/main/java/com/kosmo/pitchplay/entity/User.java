package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor // 빌더는 기본생성자에 접근을 시도하려고 하나, protected로 막혀있어 접근을 거절당하기 때문에 전체 필드에 대한 생성자를 작성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 값을 넣어야하기 때문에 생성자를 사용, 대신 기본생성자를 추가하되 접근제한을 걸어서 안정성 높임, JPA 받아들일 수 있는 최대 수준의 생성자가 PROTECTED임
@Getter // 엔티티의 경우 일관성 유지를 위해서 @Setter 어노테이션을 붙이지 않는다.
@Entity
@Table(name = "USER")
// 엔티티 다 생성하고 나서 인덱스로 태울 애들 작성하기!!! indexed = { @Index(name="", columnList="")}
@Builder // 빌더 패턴 사용
public class User {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.UUID) // 자동으로 UUID가 생성됨
    @Column(name = "user_id", nullable = false, updatable = false, unique = true, length = 36)
    // null값 비허용, 수정 비허용, 유일한 값, 길이는 36
    private String userId;

    @Column(name = "user_number", nullable = false, updatable = false, unique = true)
    // 자동으로 생성되는 6자리 유저번호, 프론트에서 uid말고 유저번호 사용 예정
    private Integer userNumber;

    // 필수정보
    @Column(name = "name", nullable = false, length = 20)
    private String name; // 성명

    @Column(name = "birthday", nullable = false, length = 20)
    private String birthday; // 생년월일

    @Column(name = "phone", nullable = false, length = 20)
    private String phone; // 휴대폰 번호

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; // 이메일

    @Column(name = "password", nullable = false, unique = true, length = 15)
    private String id; // 아이디

    @Column(name = "nickname", unique = true, length = 20)
    private String nickname; // 닉네임

    @Column(name = "password", nullable = false, length = 60)
    private String password; // 비밀번호


    // 기본정보
    @Column(name = "profile_img")
    private String profileImg;  // http://localhost:8080/프로필이미지.jpg 이런식으로 저장될 예정

    @Column
    private String favoriteCity;
    private String favoriteTime;
    private String myTeam;
    private String myDescription;
    private Integer userCash;
    private String account;
    private String accountNum;
    private Boolean profilePublic;
    private Boolean emailNotification;
    private Boolean snsNotification;
    private LocalDateTime joinDate;
    private Boolean isDeleted;
}
