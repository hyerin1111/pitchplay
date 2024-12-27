package com.kosmo.pitchplay.service;

import com.kosmo.pitchplay.converter.UserConverter;
import com.kosmo.pitchplay.dto.UserInDTO;
import com.kosmo.pitchplay.dto.UserOutDTO;
import com.kosmo.pitchplay.entity.User;
import com.kosmo.pitchplay.exception.CustomExceptions.*;
import com.kosmo.pitchplay.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        log.info("회원가입 요청: {}", userInDTO);

        // 이메일 중복 체크
        if(userRepository.existsByEmail(userInDTO.getEmail())){
            throw new DuplicateEmailException("이메일이 이미 존재합니다.");
        }

        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userInDTO.getPassword());
        userInDTO.setPassword(encryptedPassword);

        // userNumber와 joinDate 설정
        Integer userNumber = generateUserNumber();
        LocalDateTime joinDate = LocalDateTime.now();

        // DTO에서 entity로 변환
        User user = userConverter.toEntity(userInDTO);

        // userNumber와 joinDate 설정
        user = user.toBuilder()
                .userNumber(userNumber)
                .joinDate(joinDate)
                .build();

        //DB에 저장
        userRepository.save(user);
    }


    // 회원정보 불러오기 (Read)
    // 전체불러오기
    public List<UserOutDTO> getAllUserInfo(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userConverter::toDTO)
                .collect(Collectors.toList());
    }

    // JSESSION에 저장된 해당하는 userId의 유저 불러오기
    public UserOutDTO getUserInfo(HttpSession session) {
        String userUid = (String) session.getAttribute("userUid");

        if(userUid == null){
            throw new UserNotFoundException();
        }

        User user = userRepository.findById(userUid).orElseThrow(UserNotFoundException::new);

        return userConverter.toDTO(user);
    }

    // 가입년도에 해당하는 유저 불러오기
    // 유저번호로 유저 불러오기





    // 랜덤 6자리 숫자 생성
    public Integer generateUserNumber() {
        Integer userNumber;
        do {
            // 6자리 랜덤 숫자 생성 (100000 ~ 999999)
            userNumber = new Random().nextInt(900000) + 100000;
        } while (userRepository.existsByUserNumber(userNumber));

        return userNumber;
    }


//    // 회원정보 수정 (Update)
//    public void updateUser(String userUid, UserInDTO userInDTO) {
//
//    }
//
//    // 회원삭제 (Delete)
//    public void deleteUser(String userUid) {
//
//    }
}