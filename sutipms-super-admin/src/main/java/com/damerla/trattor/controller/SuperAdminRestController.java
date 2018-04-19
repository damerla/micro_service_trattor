package com.damerla.trattor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author haribabu
 * @version 1.0.0
 * @since 01/Apr/2018
 */
@RestController
@RequestMapping("/super-admin")
public class SuperAdminRestController {
    @GetMapping("/home")
    public String getCompanyList(Model model){
    return "/super_admin/super_admin_home";
    }
}
