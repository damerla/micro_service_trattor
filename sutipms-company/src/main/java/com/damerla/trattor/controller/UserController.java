package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/14/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.UserModel;
import com.damerla.trattor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute UserModel userModel, Model model) {
        userService.saveOrUpdate(userModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("userId") String userId, Model model) {
        userService.changeStatus(userId, status);
        return "";
    }

}
