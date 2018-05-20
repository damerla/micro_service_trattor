package com.damerla.trattor.controller;

import com.damerla.trattor.model.CompanyModel;
import com.damerla.trattor.model.SessionModel;
import com.damerla.trattor.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

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

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/")
    public String home(Model model) {
        CompanyModel companyModel = new CompanyModel();
        model.addAttribute("companyModel", companyModel);
        model.addAttribute("companyFilterModel", superAdminService.getCompanyName());
        return "/super_admin/super_admin_home";
    }

    @PostMapping("/homeram")
    public String home1(Model model) {
        CompanyModel companyModel = new CompanyModel();
        model.addAttribute("companyModel", companyModel);
        return "/super_admin/";
    }

    @PostMapping("/save")
    public RedirectView saveComany(@ModelAttribute CompanyModel companyModel, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
        String id = httpSession.getId();
        String name = (String) httpSession.getAttribute("name");

        // attributes.addAttribute("message","updateSuccess");
        attributes.addFlashAttribute("message", "updateSuccess");
        superAdminService.saveCompany(companyModel);
        return new RedirectView("./");
    }
}
