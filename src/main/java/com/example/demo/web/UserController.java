package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserControllern
 */
@Controller
// 대표url을 지정함으로써, 중복을 제거한다.
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/form")
    public String form() {
        return "/user/form";
    }

    @PostMapping("")
    public String create(User user) {
        System.out.println("user: " + user);
        userRepository.save(user);// db에 값 추가
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {

        // userRepository 상에서 id 값에 해당하는 유저를 user로 넘긴다.
        model.addAttribute("user", userRepository.findById(id).get());
        return "/user/updateForm";
    }
}
