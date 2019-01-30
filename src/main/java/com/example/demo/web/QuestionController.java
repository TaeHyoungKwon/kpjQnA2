package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.example.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * QuestionController
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/form")
    public String form(HttpSession session) {

        // 질문 하기에 접근할 떄,
        // 유저의 로그인 세션이 존재하지 않는다면, loginFrom으로 리다이렉팅 한다.
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }
        // 유저의 로그인 세션이 존재 한다면,
        return "/qna/form";
    }

    @PostMapping("")
    public String create(String title, String contents, HttpSession session) {
        // 유저의 로그인 세션이 존재하지 않는다면, loginFrom으로 보낸다.
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }

        // 세션으로 부터 유저를 불러온다.
        User sessionUser = HttpSessionUtils.getUserFromSession(session);
        // form으로 부터 받은 정보와 로그인 된 세션정보를 인자로 넘겨주어서, Question 객체를 생성한다.
        Question newQuestion = new Question(sessionUser.getUserId(), title, contents);
        // 생성한 Question 객체를 DB에 save 한다.
        questionRepository.save(newQuestion);

        return "redirect:/";
    }

}