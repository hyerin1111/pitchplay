package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.SocialMatch;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface SocialMatchRepository extends JpaRepository<SocialMatch, String> {
    Optional<SocialMatch> findByReservation_Id(Long reservationId); // 예약 ID로 소셜 매칭 조회

    Optional<SocialMatch> findByMatchNumber(Integer matchNumber); // matchNumber로 조회

    boolean existsByMatchNumber(Integer matchNumber); // matchNumber로 존재 여부 확인


}