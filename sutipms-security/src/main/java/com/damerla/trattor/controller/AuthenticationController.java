package com.damerla.trattor.controller;/*
 *Hari
 *4/14/2018
 *@version 1.0.0
 */

import com.damerla.trattor.enties.SuperAdminEntity;
import com.damerla.trattor.model.LoginModel;
import com.damerla.trattor.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private ILoginService loginService;

    @PostMapping("/")
    public String login(@ModelAttribute LoginModel loginModel, Model model) {
        String viewName = "forward:/home";
        SuperAdminEntity superAdminEntity = loginService.fetchSuperAdmin(loginModel);
        if (superAdminEntity != null) {
            boolean isValid = loginService.authentication(loginModel);
            if (isValid) {
                viewName = "forward:/super-admin/home";
            }
        } else {

            viewName = "forward:/home";
        }
        return viewName;
    }
}
