package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.converter.PaymentConverter;
import com.kosmo.pitchplay.dto.PaymentOutDTO;
import com.kosmo.pitchplay.entity.Payment;
import com.kosmo.pitchplay.exception.CustomExceptions;
import com.kosmo.pitchplay.repository.PaymentRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentConverter paymentConverter;

    // userId로 해당 유저의 결제내역 조회하기
    public Page<PaymentOutDTO> getUserPayments(HttpSession session, Pageable pageable) {
        String userUid = (String) session.getAttribute("userUid");

        if (userUid == null) {
            log.warn("User UID not found in session.");
            throw new CustomExceptions.UserNotFoundException();
        }

        Page<Payment> payments = paymentRepository.findByUser_UserUid(userUid, pageable);

        return payments.map(paymentConverter::toDTO);
    }
}
