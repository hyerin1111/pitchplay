package com.kosmo.pitchplay.entity;

import com.kosmo.pitchplay.enums.QnaType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "qna",
        indexes = {
                @Index(name = "idx_qna_type", columnList = "qna_type") // qna_type에 인덱스 추가
        }
)
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; // UUID로 고유 식별자 생성

    @Enumerated(EnumType.STRING)
    @Column(name = "qna_type", nullable = false)
    private QnaType qnaType; // 건의제보, 매너제재 나누기

    @Column(name = "qna_title", nullable = false, length = 255)
    private String title; // 제목

    @Lob
    @Column(name = "qna_content", nullable = false)
    private String content; // 내용

    @ManyToOne // User와의 관계 매핑 이거 다시 봐야함
    @JoinColumn(name = "user_uid", nullable = false) // 작성자의 user_uid 외래키
    private User user; // 작성자(User 엔티티와 연관)

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    @Column(name = "status", nullable = false, length = 20)
    private String status; // "처리 중", "완료"

    @Column(name = "view_count", nullable = false)
    private int viewCount; // 조회수
}
// 수정 다시하겟음


