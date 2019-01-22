package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/helloworld")
    // Model객체를 매개변수로 지정
    public String welcome(String name, int age, Model model) {
        System.out.println("name : " + name + " age : " + age);

        // addAttribute 메소드를 통해서 "name"이라는 이름으로, name 값을 저장
        // mustach template 상에서 {{name}}으로 접근 할 수 있다.
        model.addAttribute("name", name);
        return "welcome";
    }
}