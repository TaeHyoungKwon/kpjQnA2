package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository는 User에 대한 repository 이고, 두번쨰는 User의 primary Key 타입 
// 기본적으로 데이터베이스에 저장하고, 조회하는 기능 구현은 끝
public interface UserRepository extends JpaRepository<User, Long> {
    // 이를 통해 userId를 통해서 유저를 찾을 수 있다.
    User findByUserId(String userId);
}