package com.damerla.trattor.controller;

import com.damerla.trattor.model.CompanyModel;
import com.damerla.trattor.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haribabu
 * @version 1.0.0
 * @since 01/Apr/2018
 */
@Controller
@RequestMapping("/super-admin")

public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    @GetMapping("/")
    public  String home(Model model){
        CompanyModel companyModel = new CompanyModel();
        model.addAttribute("companyModel",companyModel);
        return "/super_admin/super_admin_home";
    }
    @PostMapping("/home")
    public  String home1(Model model){
        CompanyModel companyModel = new CompanyModel();
        model.addAttribute("companyModel",companyModel);
        return "/super_admin/super_admin_home";
    }

    @PostMapping("/save")
    public  String saveComany(@ModelAttribute CompanyModel companyModel, BindingResult bindingResult, Model model){
        superAdminService.saveCompany(companyModel);
        return "super_admin/super_admin_home";
    }
}
