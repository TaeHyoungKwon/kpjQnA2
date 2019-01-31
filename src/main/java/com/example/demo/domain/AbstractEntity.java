package com.example.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// 데이터 변경사항 변경시 해당되는 날짜시간을 자동으로 입력해준다.
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Long getId() {
        return this.id;
    }

    // 생성된 시간에 대한 formatted get 메소드 작성
    // template 에서 {{ formattedC reateDate }} 로 사용 가능 하다
    public String getFormattedCreateDate() {
        return getFormattedDate(createDate, "yyyy.MM.dd HH:mm");
    }

    public String getModifiedDate() {
        return getFormattedDate(modifiedDate, "yyyy.MM.dd HH:mm");
    }

    private String getFormattedDate(LocalDateTime dateTime, String format) {
        if (dateTime == null) {
            return "";
        }
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity abstractEntity = (AbstractEntity) o;
        return Objects.equals(id, abstractEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + ", createDate='" + createDate + "'" + ", modifiedDate='" + modifiedDate + "'"
                + "}";
    }

}