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

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/")
    public String login(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginModel", loginModel);
        loginService.createSuperAdmin();
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginModel loginModel, Model model) {
        String viewName = "login";
        SuperAdminEntity superAdminEntity = loginService.fetchSuperAdmin(loginModel);
        if (superAdminEntity == null) {
            boolean isValid = loginService.authentication(loginModel);
            if (isValid) {
                viewName = "/super_admin/super_admin_home";
            }
        } else {
            viewName = "/super_admin/super_admin_home";
        }
        return viewName;
    }

}
