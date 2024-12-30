package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // 필요하면 커스텀 메서드를 정의할 수 있습니다.
    List<Reservation> findByUserId(String userId); // 특정 사용자 ID로 예약 검색
}

