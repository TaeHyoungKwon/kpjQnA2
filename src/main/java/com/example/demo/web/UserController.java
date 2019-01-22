package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * UserControllern
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String create(User user) {
        System.out.println("user: " + user);
        userRepository.save(user);// db에 값 추가
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }
}
