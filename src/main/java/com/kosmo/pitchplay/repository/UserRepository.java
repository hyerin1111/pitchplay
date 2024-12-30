package com.kosmo.pitchplay.repository;

import com.kosmo.pitchplay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserNumber(Integer userNumber);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserUid(String userUid);
    Optional<User> findById(String id);
    Optional<User> findByNickname(String nickname);
    Page<User> findByIsDeleted(Boolean isDeleted, Pageable pageable);
    Boolean existsByEmail(String email);
    Boolean existsByUserNumber(Integer userNumber);

    @Query("SELECT u FROM User u WHERE FUNCTION('YEAR', u.joinDate) = :year AND u.isDeleted = :isDeleted")
    Page<User> findByYearAndIsDeleted(@Param("year") Integer year, @Param("isDeleted") Boolean isDeleted, Pageable pageable);

    // 가입날짜 년도만 추출해서 사용
    @Query("SELECT u FROM User u WHERE YEAR(u.joinDate) = :year")
    Page<User> findByJoinDate(@Param("year") Integer year, Pageable pageable);

}
