package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute AddressModel addressModel, Model model) {
        addressService.saveOrUpdate(addressModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("addressId") String addressId, Model model) {
        addressService.changeStatus(addressId, status);
        return "";
    }
}
