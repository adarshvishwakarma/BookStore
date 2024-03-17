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
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already registered");
            return "signup";
        }
        
        User newUser = new User(name, email, password);
        userRepository.save(newUser);
        return "redirect:/login";
    }
}

