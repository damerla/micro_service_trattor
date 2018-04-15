package com.damerla.trattor.controller;

import com.damerla.trattor.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author  Hari
 * @date  4/14/2018
 * @version 1.0.0
 */
@Controller
@RequestMapping("/company")
public class CompanyController {


    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String home(@ModelAttribute UserModel userModel, Model model) {
        return "";
    }

}
