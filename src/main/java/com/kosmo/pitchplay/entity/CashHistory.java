package com.kosmo.pitchplay.entity;

import com.kosmo.pitchplay.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CASH_HISTORY",
        indexes = {
                @Index(name="idx_user_uid", columnList = "user_uid")
        })
@Builder(toBuilder = true)
public class CashHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="cash_id", nullable = false, updatable = false, unique = true, length = 36)
    private String cashId; // cash uid

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_uid", nullable = false)
    private User user; // cash와 연관된 사용자 (사용자는 여러개의 cash를 가질 수 있음)

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type", nullable = false, length = 20)
    private TransactionType transactionType; // CHARGE(충전), USE(사용), REFUND(환불)

    @Column(name="amount", nullable = false)
    private Integer amount; // 캐시 금액

    @Column(name="balance", nullable = false)
    private Integer balance; // 충전, 사용, 환불 이후 남은 금액

    @Column(name="create_at", nullable = false)
    private LocalDateTime createAt; // 발생 시간
}
