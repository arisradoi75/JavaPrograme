package com.lab10.booksapp.controller;

import com.lab10.booksapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;
    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String parola,
                        Model model) {

        if (userService.login(email, parola)) {
            return "redirect:/lista-carti";
        } else {
            model.addAttribute("eroare", "Email sau parola incorecta");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String parola,
                           Model model) {

        boolean ok = userService.register(email, parola);

        if (ok) {
            model.addAttribute("mesaj", "Cont creat cu succes!");
            return "login";
        } else {
            model.addAttribute("eroare", "Email sau parola incorecta");
            return "register";
        }

    }
}
