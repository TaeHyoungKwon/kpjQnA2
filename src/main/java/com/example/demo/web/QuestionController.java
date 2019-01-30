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

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model, HttpSession session) {
        // try catch를 통해서 아래 hasPermission을 이용해서 다시 리팩토링 한다.
        // hasPermission이 true이면 정상 작동하고, hasPermission에서 throw가 발생하면, catch로 넘어간다.
        try {
            Question question = questionRepository.findById(id).get();
            hasPermission(session, question);
            model.addAttribute("question", question);
            return "/qna/updateForm";
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/login";
        }
    }

    // 기존에 로그인여부와, 본인이 쓴글에 대한 확인 부분을 하나의 메소드로 합친다.
    // 모두 통과 시 true를 반환하고, 그렇지 않을 시에는 throw를 던진다.
    private boolean hasPermission(HttpSession session, Question question) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            throw new IllegalStateException("로그인이 필요합니다!");
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        if (!question.isSameWriter(loginUser)) {
            throw new IllegalStateException("자신이 쓴 글만 수정, 삭제 가능합니다.");
        }
        return true;
    }

    // form으로 부터 전달받은 값을 통해서, 디비 값을 update 한다.
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, String title, String contents, Model model, HttpSession session) {

        try {
            Question question = questionRepository.findById(id).get();
            hasPermission(session, question);
            question.update(title, contents);
            questionRepository.save(question);
            return String.format("redirect:/questions/%d", id);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/login";
        }

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, Model model, HttpSession session) {

        // try catch를 통해서 아래 hasPermission을 이용해서 다시 리팩토링 한다.
        // hasPermission이 true이면 정상 작동하고, hasPermission에서 throw가 발생하면, catch로 넘어간다.
        try {
            Question question = questionRepository.findById(id).get();
            hasPermission(session, question);
            questionRepository.deleteById(id);
            return "redirect:/";
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/login";
        }
    }

}