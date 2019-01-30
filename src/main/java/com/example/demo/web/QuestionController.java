package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;
import com.example.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

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
        Question newQuestion = new Question(sessionUser, title, contents);
        // 생성한 Question 객체를 DB에 save 한다.
        questionRepository.save(newQuestion);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/show";
    }

    // updateForm에 질문 객체를 전달한다.
    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model, HttpSession session) {
        // 로그인 했는지 확인
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Question question = questionRepository.findById(id).get();

        // 로그인한 유저가, 글쓴 유저와 일치하는지 확인
        if (!question.isSameWriter(loginUser)) {
            return "/users/loginForm";
        }
        model.addAttribute("question", question);
        return "/qna/updateForm";
    }

    // form으로 부터 전달받은 값을 통해서, 디비 값을 update 한다.
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, String title, String contents, HttpSession session) {

        // 로그인 했는지 확인
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Question question = questionRepository.findById(id).get();

        // 로그인한 유저가, 글쓴 유저와 일치하는지 확인
        if (!question.isSameWriter(loginUser)) {
            return "/users/loginForm";
        }

        question.update(title, contents);
        questionRepository.save(question);
        return String.format("redirect:/questions/%d", id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {

        // 로그인 했는지 확인
        if (!HttpSessionUtils.isLoginUser(session)) {
            return "/users/loginForm";
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Question question = questionRepository.findById(id).get();

        // 로그인한 유저가, 글쓴 유저와 일치하는지 확인
        System.out.println(!question.isSameWriter(loginUser));
        if (!question.isSameWriter(loginUser)) {
            return "/users/loginForm";
        }

        questionRepository.deleteById(id);
        return "redirect:/";
    }

}