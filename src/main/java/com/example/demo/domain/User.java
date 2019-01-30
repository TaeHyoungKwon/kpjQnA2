package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User
 */
@Entity // User 클래스에 데이터베이스와 매핑하는 애노테이션을 추가
public class User {
    @Id
    @GeneratedValue
    private Long id; // @Id로 primary key 지정, @GeneratedValue == Auto Increment

    @Column(nullable = false, length = 20, unique = true) // null 관리
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;

    public Long getId() {
        return this.id;
    }

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

    @Override
    public String toString() {
        return "{" + " userId='" + getUserId() + "'" + ", userPassword='" + getUserPassword() + "'" + ", userName='"
                + getUserName() + "'" + ", userEmail='" + getUserEmail() + "'" + "}";
    }

    public void update(User newUser) {
        this.userPassword = newUser.userPassword;
        this.userId = newUser.userId;
        this.userName = newUser.userName;
        this.userEmail = newUser.userEmail;

    }

}