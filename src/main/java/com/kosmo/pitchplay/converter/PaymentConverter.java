package com.kosmo.pitchplay.converter;

import com.kosmo.pitchplay.dto.PaymentInDTO;
import com.kosmo.pitchplay.dto.PaymentOutDTO;
import com.kosmo.pitchplay.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {

    //PaymentInDTO 에서 Payment로 변환
    public Payment toEntity(PaymentInDTO paymentInDTO){
        return Payment.builder()
                .paymentId(paymentInDTO.getPaymentId())
                .paymentNum(paymentInDTO.getPaymentNum())
                .cashId(paymentInDTO.getCashId())
                .paidAmount(paymentInDTO.getPaidAmount())
                .payRequestedAt(paymentInDTO.getPayRequestedAt())
                .payApprovedAt(paymentInDTO.getPayApprovedAt())
                .paymentMethod(paymentInDTO.getPaymentMethod())
                .paymentStatus(paymentInDTO.getPaymentStatus())
                .build();
    }

    // Payment에서 PaymentOutDTO로 변환
    public PaymentOutDTO toDTO(Payment payment) {
        return PaymentOutDTO.builder()
                .userNumber(payment.getUser().getUserNumber())
                .name(payment.getUser().getName())
                .email(payment.getUser().getEmail())
                .phone(payment.getUser().getPhone())
                .paymentNum(payment.getPaymentNum())
                .paidAmount(payment.getPaidAmount())
                .payRequestedAt(payment.getPayRequestedAt())
                .payApprovedAt(payment.getPayApprovedAt())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getPaymentStatus())
                .refundBankName(payment.getRefundBankName())
                .build();
    }
}
