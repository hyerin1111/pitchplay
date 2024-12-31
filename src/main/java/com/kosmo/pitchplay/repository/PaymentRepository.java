package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    
    // 마이페이지에서 userUid로 결제내역들 조회
    @EntityGraph(attributePaths = {"user"}) // user 엔티티를 함께 로딩
    Page<Payment> findByUserUid(String userUid, Pageable pageable);
}
