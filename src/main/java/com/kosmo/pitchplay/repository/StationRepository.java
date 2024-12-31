package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, String> {
    // StationId를 통해 Station 조회
    Station findByStationId(String stationId);


}
