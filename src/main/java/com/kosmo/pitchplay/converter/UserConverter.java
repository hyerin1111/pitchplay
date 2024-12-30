package com.kosmo.pitchplay.converter;

import com.kosmo.pitchplay.dto.UserInDTO;
import com.kosmo.pitchplay.dto.UserOutDTO;
import com.kosmo.pitchplay.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    //UserInDTO 에서 User로 변환
    //password의 경우에는 서비스에서 코드화해서 저장 예정
    public User toEntity(UserInDTO userInDTO){
        return User.builder()
                .name(userInDTO.getName())
                .birthday(userInDTO.getBirthday())
                .phone(userInDTO.getPhone())
                .email(userInDTO.getEmail())
                .userId(userInDTO.getUserId())
                .nickname(userInDTO.getNickname())
                .profileImg(userInDTO.getProfileImg())
                .favoriteCity(userInDTO.getFavoriteCity())
                .favoriteTime(userInDTO.getFavoriteTime())
                .myDescription(userInDTO.getMyDescription())
                .account(userInDTO.getAccount())
                .accountNum(userInDTO.getAccountNum())
                .profilePublic(userInDTO.getProfilePublic() != null ? userInDTO.getProfilePublic() : true)
                .emailNotification(userInDTO.getEmailNotification() != null ? userInDTO.getEmailNotification() : false)
                .snsNotification(userInDTO.getSnsNotification() != null ? userInDTO.getSnsNotification() : false)
                .isDeleted(false)
                .build();
    }

    //User에서 userOutDTO로 변환
    public UserOutDTO toDTO(User user){
        return UserOutDTO.builder()
                .name(user.getName())
                .birthday(user.getBirthday())
                .phone(user.getPhone())
                .email(user.getEmail())
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImg(user.getProfileImg())
                .favoriteCity(user.getFavoriteCity())
                .favoriteTime(user.getFavoriteTime())
                .myTeam(user.getMyTeam())
                .myDescription(user.getMyDescription())
                .userCash(user.getUserCash())
                .account(user.getAccount())
                .accountNum(user.getAccountNum())
                .profilePublic(user.getProfilePublic())
                .emailNotification(user.getEmailNotification())
                .snsNotification(user.getSnsNotification())
                .joinDate(user.getJoinDate())
                .build();

    }
}
