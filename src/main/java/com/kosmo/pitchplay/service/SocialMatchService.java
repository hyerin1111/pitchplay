package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.dto.MemberDTO;
import com.kosmo.pitchplay.dto.SocialMatchInDTO;
import com.kosmo.pitchplay.dto.SocialMatchOutDTO;
import com.kosmo.pitchplay.entity.Member;
import com.kosmo.pitchplay.entity.Reservation;
import com.kosmo.pitchplay.entity.SocialMatch;
import com.kosmo.pitchplay.repository.ReservationRepository;
import com.kosmo.pitchplay.repository.SocialMatchRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SocialMatchService {
    private final SocialMatchRepository socialMatchRepository;
    private final ReservationRepository reservationRepository;

    // CREATE
    public SocialMatch createMatch(SocialMatchInDTO dto) {

        Integer matchNumber = generateUniqueMatchNumber(); // 6자리 고유 숫자 생성

        // reservationId가 null인지 확인
        if (dto.getReservationId() == null) {
            throw new IllegalArgumentException("Reservation ID is required");
        }

        // Reservation 조회
        Reservation reservation = reservationRepository.findById(dto.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + dto.getReservationId()));


        // SocialMatch 생성
        SocialMatch socialMatch = SocialMatch.builder()
                .matchId(UUID.randomUUID().toString())
                .matchNumber(matchNumber) // 6자리 숫자 설정
                .reservation(reservation)
                .userId(dto.getUserId())
                .stadiumId(dto.getStadiumId())
                .socialGender(dto.getSocialGender())
                .socialSize(dto.getSocialSize())
                .socialLevel(dto.getSocialLevel())
                .socialTime(dto.getSocialTime())
                .currentMember(dto.getCurrentMember() != null
                        ? dto.getCurrentMember().stream()
                        .map(memberDTO -> Member.builder()
                                .nickname(memberDTO.getNickname())
                                .profileImg(memberDTO.getProfileImg())
                                .build())
                        .collect(Collectors.toList())
                        : new ArrayList<>())
                .totalMember(dto.getTotalMember())
                .activeStatus(true)
                .viewCount(0)
                .build();



        return socialMatchRepository.save(socialMatch);
    }



    // READ (단일 조회)
    public SocialMatchOutDTO getMatchByNumber(Integer matchNumber) {
        SocialMatch match = socialMatchRepository.findByMatchNumber(matchNumber)
                .orElseThrow(() -> new RuntimeException("매칭을 찾을 수 없습니다. 매치 번호: " + matchNumber));
        return convertToOutDTO(match);
    }


    // READ (목록 조회)
    public List<SocialMatchOutDTO> getMatches(String filter) {
        List<SocialMatch> matches = socialMatchRepository.findAll(); // 조건 필터링 추가
        return matches.stream().map(this::convertToOutDTO).toList();
    }

    // UPDATE
    public SocialMatchOutDTO updateMatch(String matchId, SocialMatchInDTO dto) {
        SocialMatch match = socialMatchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("매칭을 찾을 수 없습니다."));

        // 기존 멤버 유지
        List<Member> currentMembers = match.getCurrentMember();

        // 새로운 멤버 추가
        if (dto.getCurrentMember() != null) {
            dto.getCurrentMember().forEach(memberDTO -> {
                boolean alreadyExists = currentMembers.stream()
                        .anyMatch(member -> member.getNickname().equals(memberDTO.getNickname()));

                if (!alreadyExists) {
                    currentMembers.add(Member.builder()
                            .nickname(memberDTO.getNickname())
                            .profileImg(memberDTO.getProfileImg())
                            .build());
                }
            });
        }

        // 최대 멤버 수 확인
        if (currentMembers.size() > match.getTotalMember()) {
            throw new IllegalStateException("멤버 수가 최대 허용 인원을 초과합니다.");
        }

        // 업데이트된 멤버 목록 저장
        match.setCurrentMember(currentMembers);

        // 기타 매치 정보 업데이트
        match.setSocialTime(dto.getSocialTime());
        match.setTotalMember(dto.getTotalMember());
        match.setSocialLevel(dto.getSocialLevel());

        socialMatchRepository.save(match);

        return convertToOutDTO(match);
    }



    // DELETE
    public void deleteMatch(String matchId) {
        SocialMatch match = socialMatchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("매칭을 찾을 수 없습니다."));
        match.setActiveStatus(false); // 논리 삭제
        socialMatchRepository.save(match);
    }

    // DTO 변환 메서드
    private SocialMatchOutDTO convertToOutDTO(SocialMatch match) {
        return SocialMatchOutDTO.builder()
                .matchId(match.getMatchId())
                .userId(match.getUserId())
                .stadiumId(match.getStadiumId())
                .socialGender(match.getSocialGender())
                .socialSize(match.getSocialSize())
                .socialLevel(match.getSocialLevel())
                .socialTime(match.getSocialTime())
                .totalMember(match.getTotalMember())
                .currentMember(
                        match.getCurrentMember() != null
                                ? match.getCurrentMember().stream()
                                .map(member -> MemberDTO.builder()
                                        .nickname(member.getNickname())
                                        .profileImg(member.getProfileImg()) // 변경된 필드명 적용
                                        .build())
                                .collect(Collectors.toList())
                                : new ArrayList<>()
                )
                .activeStatus(match.getActiveStatus())
                .viewCount(match.getViewCount())
                .build();
    }



    // 고유한 6자리 숫자 생성
    private Integer generateUniqueMatchNumber() {
        Integer matchNumber;
        do {
            matchNumber = new Random().nextInt(900000) + 100000; // 6자리 랜덤 숫자 (100000 ~ 999999)
        } while (socialMatchRepository.existsByMatchNumber(matchNumber)); // 중복 체크
        return matchNumber;
    }


}