package com.kosmo.pitchplay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Table
@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @Column(name = "payment_id", nullable = false, updatable = false)
    private String paymentId; // 결제 ID

    @Column(name = "payment_num", nullable = false, unique = true, updatable = false)
    @Builder.Default
    private Long paymentNum = null; // 결제 번호

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId; // 유저 ID(FK)

    @Column(name = "cash_id", nullable = false, updatable = false)
    private String cashId; // 캐쉬 ID(FK

    @Column(name = "paid_amount", nullable = false, updatable = false)
    private Long paidAmount; // 결제 금액

    @Column(name = "pay_requested_at", nullable = false)
    private LocalDateTime payRequestedAt; // 결제 요청 일시

    @Column(name = "pay_approved_at", nullable = false)
    private LocalDateTime payApprovedAt; // 결제 승인 일시

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod; // 결제 방법

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // 결제 상태

    @Column(name = "refund_bank_name")
    private String refundBankName; // 환불 은행

    @Column(name = "refund_account_holder")
    private String refundAccountHolder; // 환불 예금주

    @Column(name = "refund_account_number")
    private String refundAccountNumber; // 환불 계좌 번호

    @Column(name = "is_refunded")
    private Boolean isRefunded; // 환불 여부
}
