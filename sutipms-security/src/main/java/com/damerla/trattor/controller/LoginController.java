package com.damerla.trattor.controller;

import com.damerla.trattor.enties.SuperAdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.damerla.trattor.model.LoginModel;
import com.damerla.trattor.service.ILoginService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/")
    public String login(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginModel", loginModel);
        loginService.createSuperAdmin();
        return "login/login";
    }
    @PostMapping("/home")
    public String loginHome(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginModel", loginModel);
        loginService.createSuperAdmin();
        return "login/login";
    }



}
