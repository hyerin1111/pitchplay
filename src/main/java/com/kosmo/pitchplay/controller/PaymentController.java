package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.dto.PaymentOutDTO;
import com.kosmo.pitchplay.service.PaymentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    // 유저별 결재내역 리스트 가져오기
    @GetMapping("/user")
    public ResponseEntity<?> getPaymentsByUserUid(HttpSession session, Pageable pageable) {
        Page<PaymentOutDTO> payment = paymentService.getUserPayments(session, pageable);
        return ResponseEntity.ok(payment);
    }
}
