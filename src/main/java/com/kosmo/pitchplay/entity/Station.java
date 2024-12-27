package com.kosmo.pitchplay.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table  (
        name = "station",
        indexes = {
                @Index(name = "idx_station_name", columnList = "station_name"),
                @Index(name = "idx_station_location", columnList = "station_location"),
        }

)
// 시설, 위치, 요금
public class Station {
    // 구장id, 구장소개, 구장이름(시설명), 구장주소(위치), 이용요금, 운영시간, 전화

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "station_id", nullable = false)
    private String stationId; //구장id

    // 구장이름(시설명)
    @Column(name = "station_name", nullable = false)
    private String stationName;

    // 구장소개
    @Column(name = "station_info", nullable = false)
    private String stationInfo;

    // 구장주소(위치)
    @Column(name = "station_location", nullable = false)
    private String stationLocation;

    // 이용요금
    @Column(name = "station_charge", nullable = false)
    private String stationCharge;

    // 운영시간
    @Column(name = "station_times", nullable = false)
    private String stationTimes;

    // 전화
    @Column(name = "station_callnum", nullable = false)
    private String stationCallnum;


}
