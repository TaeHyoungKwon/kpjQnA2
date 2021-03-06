package com.example.demo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User
 */
@Entity // User 클래스에 데이터베이스와 매핑하는 애노테이션을 추가
public class User extends AbstractEntity {

    @Column(nullable = false, length = 20, unique = true) // null 관리
    @JsonProperty
    private String userId;

    @JsonIgnore
    private String userPassword;

    @JsonProperty
    private String userName;

    @JsonProperty
    private String userEmail;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean matchPassword(String newPassword) {
        if (newPassword == null) {
            return false;
        }
        return newPassword.equals(userPassword);
    }

    public boolean matchId(Long newId) {
        if (newId == null) {
            return false;
        }

        return newId.equals(getId());
    }

    public void update(User newUser) {
        this.userPassword = newUser.userPassword;
        this.userId = newUser.userId;
        this.userName = newUser.userName;
        this.userEmail = newUser.userEmail;

    }

    @Override
    public String toString() {
        return "{" + super.toString() + " userId='" + getUserId() + "'" + ", userPassword='" + getUserPassword() + "'"
                + ", userName='" + getUserName() + "'" + ", userEmail='" + getUserEmail() + "'" + "}";
    }

}