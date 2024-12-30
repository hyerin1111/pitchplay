package com.kosmo.pitchplay.service;


import com.kosmo.pitchplay.dto.NoticeDTO;
import com.kosmo.pitchplay.entity.Notice;
import com.kosmo.pitchplay.entity.User;
import com.kosmo.pitchplay.enums.NoticeType;
import com.kosmo.pitchplay.repository.NoticeRepository;
import com.kosmo.pitchplay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    //모든 글 불러오기
    public List<NoticeDTO> getNoticeALLList(){
        List<Notice> noticeAllEntities = noticeRepository.findAll();

        return noticeAllEntities.stream()
                .map(this::convertToDTO)
                .toList();
    }

    //공지사항 목록 가져오기
    public List<NoticeDTO> getNoticeList(){
        List<Notice> noticeEntities = noticeRepository.findAllByNoticeType(NoticeType.ANNOUNCEMENT);
        return noticeEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 자주 묻는 질문 목록 가져오기
    public List<NoticeDTO> getFAQList() {
        List<Notice> faqEntities = noticeRepository.findAllByNoticeType(NoticeType.FAQ);
        return faqEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    private NoticeDTO convertToDTO(Notice notice){
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setId(Long.valueOf(notice.getNoticeId()));
        noticeDTO.setNoticeType(notice.getNoticeType().name());
        noticeDTO.setTitle(notice.getTitle());

        // user nickname 값 작성자로 불러오기
        String authorUserUid = notice.getAuthorUserUid();

        // User를 직접 찾아서 nickname을 설정 (작성자는 무조건 존재한다고 가정)
        User author = userRepository.findByUserUid(authorUserUid).orElseThrow(() -> new RuntimeException("작성자를 찾을 수 없습니다."));
        noticeDTO.setAuthor(author.getNickname());


        noticeDTO.setCreateAt(notice.getCreateAt());
        noticeDTO.setStatus("해당없음");
        noticeDTO.setContent(notice.getNoticeContent());

        return noticeDTO;
    }
}
