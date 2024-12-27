package com.kosmo.pitchplay.repository;


import com.kosmo.pitchplay.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, String> {
    Notice findByTitleContaining(String keyword);
    Notice findByContentContaining(String keyword);
    Notice findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);
}
