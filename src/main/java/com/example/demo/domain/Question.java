package com.example.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ForeignKey;

//Question 모델 생성
@Entity
public class Question {

    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    // 유저 한명에 대해서 질문은 여러개 있기 때문에 writer에 대한 질문:유저 ManyToOne관계를 해주고,
    @ManyToOne
    // 외래키 이름을 아래와 같이 지정해 줄 수 있다.
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    @JsonProperty
    private User writer;

    @JsonProperty
    private String title;

    @Lob
    @JsonProperty
    private String contents;

    @JsonProperty
    private Integer countOfAnswer;

    // 질문 생성시간를 위한 컬럼 추가
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question")
    @OrderBy("id DESC")
    private List<Answer> answers;

    public Question() {

    }

    public Long getId() {
        return id;

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

    public boolean isSameWriter(User loginUser) {
        System.out.println("==========isSameWrite==========");
        System.out.println(loginUser.getId());
        System.out.println(this.writer.getId());
        System.out.println("==========isSameWrite==========");
        return this.writer.equals(loginUser);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void addAnswer() {
        this.countOfAnswer += 1;
    }

    public void minusAnswer() {
        this.countOfAnswer -= 1;
    }

}