package com.example.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Answer extends AbstractEntity {

    // 답글은 사용자에 대해서도 ManyToOne, 질문에 대해서도 ManyToOne의 관계를 가지기 떄문에
    // 아래와 같이 모두 외래키 설정 해주어야 한다.
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    @JsonProperty
    private User writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
    @JsonProperty
    private Question question;

    @Lob
    @JsonProperty
    private String contents;

    public Answer() {

    }

    public Answer(User writer, String contents, Question question) {
        this.writer = writer;
        this.question = question;
        this.contents = contents;
    }

    public User getWriter() {
        return this.writer;
    }

    public String getContents() {
        return this.contents;
    }

    public boolean isSameWriter(User loginUser) {
        return this.writer.equals(loginUser);
    }

    @Override
    public String toString() {
        return "{" + super.toString() + "'" + ", writer='" + getWriter() + "'" + ", contents='" + getContents() + "'"
                + "'" + "}";
    }

}