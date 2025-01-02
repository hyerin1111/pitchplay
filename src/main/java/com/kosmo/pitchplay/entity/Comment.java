package com.kosmo.pitchplay.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@Table(name = "COMMENT",
        indexes = {
                @Index(name = "idx_user_id", columnList = "user_id"),
                @Index(name = "idx_qna_written_date", columnList = "written_date"),
        })
@Getter
@Setter

public class Comment {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.UUID) // 자동으로 UUID가 생성됨
    @Column(name = "comment_id", nullable = false, updatable = false, unique = true, length = 36)
    private String commentId;

    // 작성자 정보 (User 엔티티와 관계)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 작성자

    @Column(name = "written_date", nullable = false)
    private LocalDateTime writtenDate; // 작성 날짜

    @Column(name = "write_revise_date", nullable = false)
    private LocalDateTime writeReviseDate; // 수정 날짜

    @Column(name = "write_content")
    private String writeContent; // 내용

    @PrePersist
    public void prePersist() {
        if (this.writeReviseDate == null) {
            this.writeReviseDate = this.writtenDate; // 수정 날짜가 없으면 작성 날짜로 초기화
        }
    }
}
