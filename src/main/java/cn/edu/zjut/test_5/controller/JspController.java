package cn.edu.zjut.test_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Boot中支持jsp功能的实现
 */
@Controller
public class JspController {

    @GetMapping("/register")
    public String register(Model model) {

        return "register";
    }
    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }

}
