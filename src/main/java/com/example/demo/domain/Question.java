package com.example.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

//Question 모델 생성
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    // 유저 한명에 대해서 질문은 여러개 있기 때문에 writer에 대한 질문:유저 ManyToOne관계를 해주고,
    @ManyToOne
    // 외래키 이름을 아래와 같이 지정해 줄 수 있다.
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private User writer;
    private String title;
    private String contents;

    // 질문 생성시간를 위한 컬럼 추가
    private LocalDateTime createDate;

    public Question() {

    }

    public Question(User writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        // 생성시간을 현재시간으로 초기화
        this.createDate = LocalDateTime.now();
    }

    // 생성된 시간에 대한 formatted get 메소드 작성
    // template 에서 {{ formattedC reateDate }} 로 사용 가능 하다
    public String getFormattedCreateDate() {
        if (createDate == null) {
            return "";
        }
        return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}