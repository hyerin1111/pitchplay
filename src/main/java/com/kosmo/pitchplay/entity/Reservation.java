package com.kosmo.pitchplay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @Column(name = "stadium_id", nullable = false)
    private String stadiumId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    // 나머지 필드 및 관계 매핑...
}
