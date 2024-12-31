package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.dto.TeamInDTO;
import com.kosmo.pitchplay.dto.TeamOutDTO;
import com.kosmo.pitchplay.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    // 팀 생성(create)
    @PostMapping
    public ResponseEntity<TeamOutDTO> createTeam(
            @RequestBody TeamInDTO teamInDTO,
            @RequestHeader("userUid") String userUid) {  // userUid를 헤더에서 받음

        TeamOutDTO createdTeam = teamService.createTeam(teamInDTO, userUid);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }
}
