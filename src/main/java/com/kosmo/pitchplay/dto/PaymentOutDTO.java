package com.kosmo.pitchplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PaymentOutDTO {
    // 유저관련
    private String userNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String bankName;

    // 결제관련
    private String paymentNum;
    private Long paidAmount;
    private LocalDateTime payRequestedAt;
    private LocalDateTime payApprovedAt;
    private String paymentMethod;
    private String paymentStatus;
    private String refundBankName;

}
