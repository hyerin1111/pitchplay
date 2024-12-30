package com.kosmo.pitchplay.controller;

import com.kosmo.pitchplay.dto.SocialMatchInDTO;
import com.kosmo.pitchplay.service.SocialMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/social-match")
@RequiredArgsConstructor
public class SocialMatchController {
    private final SocialMatchService socialMatchService;

    @PostMapping
    public ResponseEntity<?> createMatch(@RequestBody SocialMatchInDTO dto) {
        return ResponseEntity.ok(socialMatchService.createMatch(dto));
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getMatch(@PathVariable("number") Integer matchNumber) {
        return ResponseEntity.ok(socialMatchService.getMatchByNumber(matchNumber));
    }

    @GetMapping
    public ResponseEntity<?> getMatches(@RequestParam(required = false) String filter) {
        return ResponseEntity.ok(socialMatchService.getMatches(filter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMatch(@PathVariable String id, @RequestBody SocialMatchInDTO dto) {
        return ResponseEntity.ok(socialMatchService.updateMatch(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable String id) {
        socialMatchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }
}