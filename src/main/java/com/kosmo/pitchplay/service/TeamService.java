package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.converter.TeamConverter;
import com.kosmo.pitchplay.dto.TeamInDTO;
import com.kosmo.pitchplay.dto.TeamOutDTO;
import com.kosmo.pitchplay.entity.Team;
import com.kosmo.pitchplay.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;

    public TeamService(TeamRepository teamRepository, TeamConverter teamConverter) {
        this.teamRepository = teamRepository;
        this.teamConverter = teamConverter;
    }

    // 팀 생성
    @Transactional(rollbackFor = Exception.class)
    public TeamOutDTO createTeam(TeamInDTO teamInDTO, String userUid) {  // userUid를 파라미터로 받음
        try {
            validateRequiredFields(teamInDTO);
            checkTeamCode(teamInDTO.getTeamCode());
            validateTeamMemberCount(teamInDTO.getTeamMemberCount());

            // 팀 생성 시 사용자 ID(userUid) 추가
            Team team = teamConverter.toEntity(teamInDTO);
            team.setUserUid(userUid);  // 로그인한 사용자의 userUid를 팀에 설정

            Team savedTeam = teamRepository.save(team);

            return teamConverter.toDTO(savedTeam);
        } catch (Exception e) {
            // 예외 발생 시 롤백 및 예외 메시지 출력
            throw new RuntimeException("팀 생성 중 오류 발생", e);
        }
    }

    private void validateRequiredFields(TeamInDTO teamInDTO) {
        if (teamInDTO.getTeamName() == null || teamInDTO.getTeamName().isBlank()){
            throw new IllegalArgumentException("팀 이름은 1~15자의 한글, 영문, 숫자, 특수문자만 허용됩니다. 첫글자는 한글과 영어만 가능합니다.");
        }
        if (teamInDTO.getTeamCode() == null || teamInDTO.getTeamCode().isBlank()){
            throw new IllegalArgumentException("팀 코드는 1~20자의 영문, 숫자만 허용됩니다. 첫글자는 영문만 가능합니다.");
        }
    }

    private void checkTeamCode(String teamCode) {
        Optional<Team> existingTeam = teamRepository.findByTeamCode(teamCode);
        if (existingTeam.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 팀 코드 입니다.");
        }
    }

    private void validateTeamMemberCount(Integer teamMemberCount) {
        if (teamMemberCount != null && teamMemberCount > 30) {
            throw new IllegalArgumentException("팀원은 최대 30명까지 가능합니다.");
        }
    }

}
