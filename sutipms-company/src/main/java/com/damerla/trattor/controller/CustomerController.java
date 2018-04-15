package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.model.CustomerModel;
import com.damerla.trattor.service.AddressService;
import com.damerla.trattor.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute CustomerModel customerModel, Model model) {
        customerService.saveOrUpdate(customerModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("customerId") String customerId, Model model) {
        customerService.changeStatus(customerId, status);
        return "";
    }
}
