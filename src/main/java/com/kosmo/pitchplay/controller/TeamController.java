package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.dto.TeamInDTO;
import com.kosmo.pitchplay.dto.TeamOutDTO;
import com.kosmo.pitchplay.service.TeamService;
import jakarta.servlet.http.HttpSession;
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
            HttpSession session){ // 세션에서 userUid를 가져옴

        String userUid = (String) session.getAttribute("userUid");
        if (userUid == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        TeamOutDTO createdTeam = teamService.createTeam(teamInDTO, userUid);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    // 팀 정보 수정 ( 팀 리더만 )
    @PutMapping("/{teamCode}")
    public ResponseEntity<TeamOutDTO> updateTeam(
            @PathVariable(name = "teamCode") String teamCode,
            @RequestBody TeamInDTO teamInDTO,
            HttpSession session) {

        String userUid = (String) session.getAttribute("userUid");
        if (userUid == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        try{
            teamService.updateTeam(teamCode, userUid, teamInDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); // 권한이 없는 경우
        }
    }



}

