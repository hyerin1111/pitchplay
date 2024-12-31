package com.kosmo.pitchplay.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PaymentOutDTO {
    // 유저관련(User)
    private Integer userNumber;
    private String name;
    private String email;
    private String phone;
    private String bankName;

    // 결제관련(Payment)
    private Long paymentNum;
    private Long paidAmount;
    private LocalDateTime payRequestedAt;
    private LocalDateTime payApprovedAt;
    private String paymentMethod;
    private String paymentStatus;
    private String refundBankName;

}
