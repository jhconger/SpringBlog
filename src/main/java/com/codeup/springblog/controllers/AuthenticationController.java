package com.codeup.springblog.controllers;

import com.codeup.springblog.model.User;
//import com.codeup.springblog.repositories.UserRepository;
//import com.codeup.springblog.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

//    private final UserRepository userDao;
//    private final UserService userService;

    //    public AuthenticationController(UserRepository userDao) {
//        this.userDao = userDao;
//    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @GetMapping("/profile")
    public String goToProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUsername());
        model.addAttribute("user", user);
        return "users/profile";
    }
        @PostMapping("/login")
    public String showProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "redirect:/profile";
    }
}