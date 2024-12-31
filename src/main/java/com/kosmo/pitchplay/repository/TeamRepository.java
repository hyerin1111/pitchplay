package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    Optional<Team> findByTeamCode(String teamCode);
}
