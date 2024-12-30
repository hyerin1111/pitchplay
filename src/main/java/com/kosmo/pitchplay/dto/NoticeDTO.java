package com.kosmo.pitchplay.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeDTO {
    private Long id; // 게시글 번호
    private String noticeType; //카테고리
    private String title; //제목
    private String author; //작성자
    private LocalDateTime createAt; // 작성일
    private String status; //처리상태

    private String content; //글
}
