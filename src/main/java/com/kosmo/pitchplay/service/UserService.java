package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.converter.UserConverter;
import com.kosmo.pitchplay.dto.UserInDTO;
import com.kosmo.pitchplay.dto.UserOutDTO;
import com.kosmo.pitchplay.entity.User;
import com.kosmo.pitchplay.exception.CustomExceptions.*;
import com.kosmo.pitchplay.repository.TeamRepository;
import com.kosmo.pitchplay.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    // 회원가입 (Create)   ** 이메일 중복검사 및 인증번호는 따로 authService 생성예정
    @Transactional
    public void registerUser(UserInDTO userInDTO) {

        // 이메일 중복 체크
        if (userRepository.existsByEmail(userInDTO.getEmail())) {
            throw new DuplicateException("이메일이 이미 존재합니다.");
        }

        // 아이디 중복 체크
        if (userRepository.existsByUserId(userInDTO.getUserId())) {
            throw new DuplicateException("아이디가 이미 존재합니다.");
        }

        // 닉네임 중복 체크
        if (userRepository.existsByNickname(userInDTO.getNickname())) {
            throw new DuplicateException("닉네임이 이미 존재합니다.");
        }

        // 휴대폰 번호 중복 체크
        if (userRepository.existsByPhone(userInDTO.getPhone())) {
            throw new DuplicateException("휴대폰 번호가 이미 존재합니다.");
        }

        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userInDTO.getPassword());

        // userNumber와 joinDate 설정
        Integer userNumber = generateUserNumber();
        LocalDateTime joinDate = LocalDateTime.now();

        // DTO에서 entity로 변환
        User user = userConverter.toEntity(userInDTO);

        // 암호화된 비밀번호와 기타 필드들 설정
        user = user.toBuilder()
                .password(encryptedPassword)  // 암호화된 비밀번호 설정
                .userNumber(userNumber)       // userNumber 설정
                .joinDate(joinDate)           // joinDate 설정
                .build();

        //DB에 저장
        userRepository.save(user);
    }


    // 회원정보 불러오기 (Read)
    // 유저 전체(페이지처리) - Admin 사용
    public Page<UserOutDTO> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        return users.map(userConverter::toDTO);
    }

    // 가입년도에 해당하는 유저 전체 (페이지처리) - Admin 사용
    public Page<UserOutDTO> getUsersByYear(Integer year, Pageable pageable) {
        // User 엔티티의 결과를 DTO로 변환
        Page<User> users = userRepository.findByJoinDate(year, pageable);
        return users.map(userConverter::toDTO);
    }

    // 탈퇴여부 (페이지처리)
    public Page<UserOutDTO> getUsersByIsDeleted(Boolean isDeleted, Pageable pageable) {
        Page<User> users = userRepository.findByIsDeleted(isDeleted, pageable);

        return users.map(userConverter::toDTO);
    }

    // 가입년도와 탈퇴 여부 (페이지처리)
    public Page<UserOutDTO> getUsersByYearAndIsDeleted(Integer year, Boolean isDeleted, Pageable pageable) {
        // 가입년도(year)와 탈퇴 여부(isDeleted)를 모두 필터링하여 조회
        Page<User> users = userRepository.findByYearAndIsDeleted(year, isDeleted, pageable);

        return users.map(userConverter::toDTO);
    }

    // 유저번호
    public UserOutDTO getUserByUserNumber(Integer userNumber) {
        User user = userRepository.findByUserNumber(userNumber).orElseThrow(UserNotFoundException::new);
        return userConverter.toDTO(user);
    }

    // 유저이메일
    public UserOutDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return userConverter.toDTO(user);
    }

    // 유저ID (유저가 지정한 ID)
    public UserOutDTO getUserByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return userConverter.toDTO(user.orElseThrow(() -> new UserNotFoundException()));
    }

    // 유저별명
    public UserOutDTO getUserByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname).orElseThrow(UserNotFoundException::new);
        return userConverter.toDTO(user);
    }

    // JSESSION에 저장된 userUid
    public UserOutDTO getUserByUserUid(HttpSession session) {
        String userUid = (String) session.getAttribute("userUid");

        if (userUid == null) {
            throw new UserNotFoundException();
        }

        User user = userRepository.findByUserUid(userUid).orElseThrow(() -> new UserNotFoundException());

        return userConverter.toDTO(user);
    }

    // 회원정보 수정 (Update) ** 회원이 수정할 수 있는 부분만 변경
    public UserOutDTO updateUser(HttpSession session, UserInDTO userInDTO) {
        // 해당 유저 찾기
        String userUid = (String) session.getAttribute("userUid");
        User user = userRepository.findByUserUid(userUid).orElseThrow(() -> new UserNotFoundException());

        // userInDTO를 User로 변환
        User updatedUser = userConverter.toEntity(userInDTO);

        // 기존 유저 정보에 변환된 정보 합침
        updatedUser = user.toBuilder()
                .birthday(updatedUser.getBirthday() != null ? updatedUser.getBirthday() : user.getBirthday())
                .phone(updatedUser.getPhone() != null ? updatedUser.getPhone() : user.getPhone())
                .password(updatedUser.getPassword() != null ? updatedUser.getPassword() : user.getPassword())
                .profileImg(updatedUser.getProfileImg() != null ? updatedUser.getProfileImg() : user.getProfileImg())
                .favoriteCity(updatedUser.getFavoriteCity() != null ? updatedUser.getFavoriteCity() : user.getFavoriteCity())
                .favoriteTime(updatedUser.getFavoriteTime() != null ? updatedUser.getFavoriteTime() : user.getFavoriteTime())
                .myDescription(updatedUser.getMyDescription() != null ? updatedUser.getMyDescription() : user.getMyDescription())
                .account(updatedUser.getAccount() != null ? updatedUser.getAccount() : user.getAccount())
                .accountNum(updatedUser.getAccountNum() != null ? updatedUser.getAccountNum() : user.getAccountNum())
                .profilePublic(updatedUser.getProfilePublic() != null ? updatedUser.getProfilePublic() : user.getProfilePublic())
                .emailNotification(updatedUser.getEmailNotification() != null ? updatedUser.getEmailNotification() : user.getEmailNotification())
                .snsNotification(updatedUser.getSnsNotification() != null ? updatedUser.getSnsNotification() : user.getSnsNotification())
                .build();

        // 수정된 User 객체 저장
        userRepository.save(updatedUser);
        return userConverter.toDTO(updatedUser);
    }

    // 회원삭제 (Delete)   ** 탈퇴시에 userUid, userNumber, id, userCash는 저장
    public void deleteUser(HttpSession session) {
        //해당 유저 찾기
        String userUid = (String) session.getAttribute("userUid");
        User user = userRepository.findByUserUid(userUid).orElseThrow(() -> new UserNotFoundException());

        // ******** teamRepository 완성되면 로직 넣기 해당 유저가 속한 팀의 teamMember에서 제거

        // 탈퇴 일자 및 탈퇴 상태 업데이트
        user = user.toBuilder()
                .name("---")
                .birthday("---")
                .phone("---")
                .email("---")
                .password("---")
                .profileImg("---")
                .favoriteCity("---")
                .favoriteTime("---")
                .myTeam("---")
                .myDescription("---")
                .account("---")
                .accountNum("---")
                .profilePublic(false)
                .emailNotification(false)
                .snsNotification(false)
                .isDeleted(true)
                .deleteDate(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }


    // 랜덤 6자리 숫자 생성
    public Integer generateUserNumber() {
        Integer userNumber;
        do {
            // 6자리 랜덤 숫자 생성 (100000 ~ 999999)
            userNumber = new Random().nextInt(900000) + 100000;
        } while (userRepository.existsByUserNumber(userNumber));

        return userNumber;
    }
}

