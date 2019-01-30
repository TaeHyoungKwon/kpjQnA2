package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.Answer;
import com.example.demo.domain.AnswerRepository;
import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.example.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("")
    public String create(@PathVariable Long questionId, String contents, HttpSession session) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }
        // 로그인 유저 객체
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        // 인자로 받은 questionId 값에 해당하는 질문
        Question question = questionRepository.findById(questionId).get();
        // 로그인 유저와, 질문, form으로 부터 받은 값을 넘겨서 Answer 객체를 생성한다.
        Answer answer = new Answer(loginUser, contents, question);

        // Answer DB에 저장한다.
        answerRepository.save(answer);

        return String.format("redirect:/questions/%d", questionId);
    }

}