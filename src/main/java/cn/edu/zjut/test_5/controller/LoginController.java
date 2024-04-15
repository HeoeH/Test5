package cn.edu.zjut.test_5.controller;

import cn.edu.zjut.test_5.entity.User;
import cn.edu.zjut.test_5.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class LoginController  {


    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                      @RequestParam(value = "password") String password,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if((username==null ||username.isEmpty())&&(password==null ||password.isEmpty()) ){
            String msg = "用户名和密码不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回注册失败页面
        }
        else if (username == null|| username.isEmpty()) {
            String msg = "用户名不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回登录失败页面
        } else if (password == null|| password.isEmpty()) {
            String msg = "密码不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回登录失败页面
        } else {
            User user = userService.login(username, password);
            if (user != null) {
                session.setAttribute("username", username); // 将用户信息存入 Session 中
                RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome");
                return "welcome"; // 重定向到欢迎页面
            } else {
                return "fail"; // 返回注册失败页面
            }
        }
    }
}