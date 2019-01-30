package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//생성한 Question 모델에 대한 JpaRepository를 상속하는 QuestionREpository 인터페이스
public interface QuestionRepository extends JpaRepository<Question, Long> {

}