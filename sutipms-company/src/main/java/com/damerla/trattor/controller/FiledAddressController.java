package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.FieldAddressEntity;
import com.damerla.trattor.model.CustomerModel;
import com.damerla.trattor.model.FieldAddressModel;
import com.damerla.trattor.service.CustomerService;
import com.damerla.trattor.service.FiledAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filedAddress")
public class FiledAddressController {

    @Autowired
    private FiledAddressService filedAddressService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute FieldAddressModel customerModel, Model model) {
        filedAddressService.saveOrUpdate(customerModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("fieldAddressId") String fieldAddressId, Model model) {
        filedAddressService.changeStatus(fieldAddressId, status);
        return "";
    }
}
