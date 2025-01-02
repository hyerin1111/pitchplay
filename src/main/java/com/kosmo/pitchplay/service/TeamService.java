package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.converter.TeamConverter;
import com.kosmo.pitchplay.dto.TeamInDTO;
import com.kosmo.pitchplay.dto.TeamOutDTO;
import com.kosmo.pitchplay.entity.Team;
import com.kosmo.pitchplay.enums.TeamRole;
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
            checkIfUserHasExistingTeam(userUid);
            validateRequiredFields(teamInDTO);
            checkTeamCode(teamInDTO.getTeamCode());
            validateTeamMemberCount(teamInDTO.getTeamMemberCount());

            // 팀 생성 시 사용자 ID(userUid) 추가
            Team team = teamConverter.toEntity(teamInDTO);
            team.setUserUid(userUid);  // 로그인한 사용자의 userUid를 팀에 설정

            // 팀공개가 null인 경우 기본값 true로 설정
            if (team.getTeamPublic() == null) {
                team.setTeamPublic(true);
            }

            // 팀 생성자가 자동으로 리더가 되도록 설정
            team.addMember(userUid, TeamRole.LEADER); // 리더 역할 추가

            Team savedTeam = teamRepository.save(team);

            return teamConverter.toDTO(savedTeam);
        } catch (Exception e) {
            // 예외 발생 시 롤백 및 예외 메시지 출력
            throw new RuntimeException("팀 생성 중 오류 발생", e);
        }
    }

    // 사용자가 이미 속한 팀이 있는지 확인
    private void checkIfUserHasExistingTeam(String userUid) {
        Optional<Team> existingTeam = teamRepository.findByUserUid(userUid);
        if (existingTeam.isPresent()) {
            throw new IllegalArgumentException("이미 속한 팀이 있습니다.");
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

    // 팀 리더가 팀에 대한 정보를 수정
    @Transactional
    public TeamOutDTO updateTeam(String teamCode, String userUid, TeamInDTO teamInDTO) {
        Team team = teamRepository.findByTeamCode(teamCode)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다."));

        // 팀 리더만 수정 가능
        if (!team.getUserUid().equals(userUid)) {
            throw new IllegalArgumentException("팀 리더만 팀 정보를 수정할 수 있습니다.");
        }

        // TeamInDTO를 Team으로 변환
        Team updatedTeam = teamConverter.toEntity(teamInDTO);

        // 팀 정보 수정되지 말아야 할 것들만 작성
        updatedTeam = team.builder()
                .teamId(team.getTeamId())
                .teamCode(team.getTeamCode())  // 기존 teamCode를 그대로 유지
                .teamName(team.getTeamName())
                .userUid(team.getUserUid())
                // null이 아닐 때만 수정하도록 조건 추가
                .teamPlayDay(updatedTeam.getTeamPlayDay() != null ? updatedTeam.getTeamPlayDay() : team.getTeamPlayDay())
                .teamPlayTime(updatedTeam.getTeamPlayTime() != null ? updatedTeam.getTeamPlayTime() : team.getTeamPlayTime())
                .teamLevel(updatedTeam.getTeamLevel() != null ? updatedTeam.getTeamLevel() : team.getTeamLevel())
                .teamRegion(updatedTeam.getTeamRegion() != null ? updatedTeam.getTeamRegion() : team.getTeamRegion())
                .teamImageUrl(updatedTeam.getTeamImageUrl() != null ? updatedTeam.getTeamImageUrl() : team.getTeamImageUrl())
                .teamIntroduce(updatedTeam.getTeamIntroduce() != null ? updatedTeam.getTeamIntroduce() : team.getTeamIntroduce())
                .teamByAge(updatedTeam.getTeamByAge() != null ? updatedTeam.getTeamByAge() : team.getTeamByAge())
                .stadiumName(updatedTeam.getStadiumName() != null ? updatedTeam.getStadiumName() : team.getStadiumName())
                .teamPublic(updatedTeam.getTeamPublic() != null ? updatedTeam.getTeamPublic() : team.getTeamPublic())
                .build();

        teamRepository.save(updatedTeam);

        return teamConverter.toDTO(updatedTeam);  // 수정된 팀 정보를 반환
    }

    // 팀원 추가 및 가입 승인 처리
    @Transactional
    public void approveMember(String teamId, String userUid) {
        // 팀 조회
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀을 찾을 수 없습니다."));

        // 팀 리더 또는 매니저만 승인할 수 있도록
        if (!isAuthorizedUser(team, userUid)) {
            throw new IllegalArgumentException("팀리더 혹은 매니저만 팀원 추가가 가능합니다.");
        }

        // 가입 승인이 되면 팀에 추가하고 역할을 MEMBER로 설정
        team.addMember(userUid, TeamRole.MEMBER);
        teamRepository.save(team);
    }

    // 가입 거절 처리
    @Transactional
    public void rejectMembershipRequest(String teamId, String userUid) {
        // 팀 조회
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀을 찾을 수 없습니다."));

        // 팀 리더 또는 매니저만 가입 거절할 수 있도록
        if (!isAuthorizedUser(team, userUid)) {
            throw new IllegalArgumentException("팀리더 혹은 매니저만 팀원 거절이 가능합니다.");
        }

        // 가입 대기 목록에서 사용자 제거 (가입 거절)
        if (team.getPendingMembers().contains(userUid)) {
            team.removePendingMember(userUid);
            teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("가입 요청이 없는 사용자입니다.");
        }
    }

    // 가입 대기 중인 사용자를 관리하는 메서드 (가입 대기 목록 추가)
    public void addPendingMember(String teamId, String userUid) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀을 찾을 수 없습니다."));
        team.addPendingMember(userUid); // 가입 대기 목록에 사용자 추가
        teamRepository.save(team);
    }

    // 팀원 삭제
    @Transactional
    public void removeMember(String teamId, String userUid) {
        // 팀 조회
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀을 찾을 수 없습니다."));

        // 팀 리더 또는 관리자만 멤버를 삭제할 수 있도록 제한
        if (!isAuthorizedUser(team, userUid)) {
            throw new IllegalArgumentException("팀 리더 또는 관리자만 멤버를 삭제할 수 있습니다.");
        }

        // 멤버 삭제
        team.removeMember(userUid);
        teamRepository.save(team);
    }

    // 권한 확인 메서드
    public boolean isAuthorizedUser(Team team, String userUid) {
        return team.getUserUid().equals(userUid) ||
                team.getTeamMembers().get(userUid) == TeamRole.MANAGER;
    }


}
