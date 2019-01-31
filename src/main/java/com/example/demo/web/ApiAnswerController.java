package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.Answer;
import com.example.demo.domain.AnswerRepository;
import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.example.demo.domain.Result;
import com.example.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//기존의 파일명을 접두어로Api를 붙인 형태로 바꾼다.
//Json 응답을 하기 때문에 Controller를 RestController로 바꿔준다.
@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class ApiAnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // 메소드의 반환형이 Answer 객체이다.
    @PostMapping("")
    public Answer create(@PathVariable Long questionId, String contents, HttpSession session) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            return null;
        }
        // 로그인 유저 객체
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        // 인자로 받은 questionId 값에 해당하는 질문
        Question question = questionRepository.findById(questionId).get();
        // 로그인 유저와, 질문, form으로 부터 받은 값을 넘겨서 Answer 객체를 생성한다.
        Answer answer = new Answer(loginUser, contents, question);

        question.addAnswer();
        // 저장하는 answer 객체를 리턴한다.
        // 이때 클라이언트로 가는 json 응답은 Answer 객체에서 getter 메소드가 구현되어있거나,
        // 따로 지정해준것에 한해서, 응답이 보내진다.
        return answerRepository.save(answer);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session) {
        System.out.println("KwontaeHyoung!");
        if (!HttpSessionUtils.isLoginUser(session)) {
            return Result.fail("로그인해야합니다.");
        }

        Answer answer = answerRepository.findById(id).get();
        User loginUser = HttpSessionUtils.getUserFromSession(session);

        if (!answer.isSameWriter(loginUser)) {
            return Result.fail("사용자 정보가 일치하지 않습니다.");
        }

        answerRepository.deleteById(id);
        Question question = questionRepository.findById(questionId).get();
        question.minusAnswer();
        questionRepository.save(question);
        return Result.ok();

    }
}