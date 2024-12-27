package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNumber(Integer userNumber);
    User findByEmail(String email);
    User findByUserId(String id);
    User findByNickname(String nickname);
    Boolean existsByEmail(String email);
    Boolean existsByUserNumber(Integer userNumber);

    // 가입날짜 년도만 추출해서 사용
    @Query("SELECT u FROM User u WHERE YEAR(u.joinDate) = :year")
    List<User> findByJoinDate(@Param("year") Integer year);
}
