package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.User;

public class HttpSessionUtils {

    // USER_SESSION_KEY 라는 공통적으로 사용하는 변하지않는 변수를 지정한다.
    public static final String USER_SESSION_KEY = "sessionedUser";

    // 로그인 여부를 확인하는 메소드
    public static boolean isLoginUser(HttpSession session) {
        // 세션정보를 받아와서 세션 정보가 없으면 false, 있으면 true를 반환한다.
        Object sessionedUser = session.getAttribute(USER_SESSION_KEY);

        if (sessionedUser == null) {
            return false;
        }
        return true;
    }

    // 세션으로부터, 로그인한 사용자의 정보를 가져온다.
    // 로그인 세션이 확인 되면 세션에 해당하는 유저정보를 리턴한다.
    public static User getUserFromSession(HttpSession session) {
        if (!isLoginUser(session)) {
            return null;
        }
        return (User) session.getAttribute(USER_SESSION_KEY);
    }

}