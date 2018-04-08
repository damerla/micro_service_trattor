package com.damerla.trattor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haribabu
 * @version 1.0.0
 * @since 01/Apr/2018
 */
@RestController
@RequestMapping("/super-admin")
public class SuperAdminRestController {
    @RequestMapping( name = "/home" ,method = RequestMethod.GET )
    public String getCompanyList(Model model){
    return null;
    }
}
