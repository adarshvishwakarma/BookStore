package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookStore.entity.*;
import com.bookStore.repository.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "signup";
        }
    }
}

