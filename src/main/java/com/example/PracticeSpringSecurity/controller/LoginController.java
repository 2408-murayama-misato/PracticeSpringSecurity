package com.example.PracticeSpringSecurity.controller;

import com.example.PracticeSpringSecurity.controller.form.UserForm;
import com.example.PracticeSpringSecurity.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;

    // ログイン画面表示
    @GetMapping("/login")
    public String showLogin(@ModelAttribute UserForm userForm) {
        // templatesフォルダ配下のlogin.htmlに遷移させる
        return "login";
    }
}
