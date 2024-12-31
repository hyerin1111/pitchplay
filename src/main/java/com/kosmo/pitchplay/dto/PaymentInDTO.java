package com.kosmo.pitchplay.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentInDTO {
    private String paymentId;
    private Long paymentNum;
    private String userId;
    private String cashId;
    private Long paidAmount;
    private LocalDateTime payRequestedAt;
    private LocalDateTime payApprovedAt;
    private String paymentMethod;
    private String paymentStatus;
}