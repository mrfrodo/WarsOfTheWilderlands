package com.frodo.wars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("message", "Welcome to HTMX with Spring Boot!");
        return "welcome-to-wars";
    }

}
