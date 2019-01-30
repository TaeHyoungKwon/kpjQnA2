package com.example.demo.web;

import com.example.demo.domain.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */

// HomeController는 root 페이지에 대해 보여준다.
// QuestionRepository에서 값을 불러와서, model로 template으로 값을 넘겨준다.
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("questions", questionRepository.findAll());
        System.out.println("====================");
        System.out.println(questionRepository.findAll());
        System.out.println("====================");
        return "index";
    }
}