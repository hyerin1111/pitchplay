package com.kosmo.pitchplay.converter;

import com.kosmo.pitchplay.dto.TeamInDTO;
import com.kosmo.pitchplay.dto.TeamOutDTO;
import com.kosmo.pitchplay.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    // TeamInDTO 에서 Team으로 변환
    public Team toEntity(TeamInDTO teamInDTO){
        return Team.builder()
                .teamCode(teamInDTO.getTeamCode())
                .teamName(teamInDTO.getTeamName())
                .userUid(teamInDTO.getUserUid())
                .teamLevel(teamInDTO.getTeamLevel())
                .teamRegion(teamInDTO.getTeamRegion())
                .teamPlayDay(teamInDTO.getTeamPlayDay())
                .teamPlayTime(teamInDTO.getTeamPlayTime())
                .teamImageUrl(teamInDTO.getTeamImageUrl())
                .teamMember(teamInDTO.getTeamMember())
                .teamMemberCount(teamInDTO.getTeamMemberCount())
                .teamIntroduce(teamInDTO.getTeamIntroduce())
                .teamByAge(teamInDTO.getTeamByAge())
                .stadiumName(teamInDTO.getStadiumName())
                .teamPublic(teamInDTO.getTeamPublic())
                .build();
    }




    // Team에서 teamOutDTO로 변환
    public TeamOutDTO toDTO(Team team){

        // teamMemberCount는 teamMember.size()로 계산
        Integer teamMemberCount = team.getTeamMember() != null ? team.getTeamMember().size() : 0;

        return TeamOutDTO.builder()
                .teamCode(team.getTeamCode())
                .teamName(team.getTeamName())
                .userUid(team.getUserUid())
                .teamLevel(team.getTeamLevel())
                .teamRegion(team.getTeamRegion())
                .teamPlayDay(team.getTeamPlayDay())
                .teamPlayTime(team.getTeamPlayTime())
                .teamImageUrl(team.getTeamImageUrl())
                .teamMember(team.getTeamMember())
                .teamMemberCount(teamMemberCount)
                .teamIntroduce(team.getTeamIntroduce())
                .teamByAge(team.getTeamByAge())
                .stadiumName(team.getStadiumName())
                .teamPublic(team.getTeamPublic())
                .build();
    }
}
