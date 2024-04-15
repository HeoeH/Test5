package cn.edu.zjut.test_5.controller;

import cn.edu.zjut.test_5.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(String username, String password, HttpSession session) {
        if((username==null ||username.isEmpty())&&(password==null ||password.isEmpty()) ){
            String msg = "用户名和密码不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回注册失败页面
        }
        else if (username == null|| username.isEmpty()) {
            String msg = "用户名不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回注册失败页面
        } else if (password == null|| password.isEmpty()) {
            String msg = "密码不能为空";
            session.setAttribute("msg", msg);
            return "fail"; // 返回注册失败页面
        }else {
            Integer isRegistered = userService.register(username, password);
            if (isRegistered > 0) {
                session.setAttribute("username", username);
                return "welcome"; // 重定向到欢迎页面
            } else {
                return "fail"; // 返回注册失败页面
            }
        }
    }
}
