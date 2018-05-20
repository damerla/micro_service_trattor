package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.model.CustomerModel;
import com.damerla.trattor.persistence.IAddressEntityRepository;
import com.damerla.trattor.service.AddressService;
import com.damerla.trattor.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private IAddressEntityRepository addressEntityRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("customerModel", customerService.buildCustomerModel());

        return "company/customers";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public RedirectView create(@ModelAttribute CustomerModel customerModel, Model model, RedirectAttributes attributes) {
        Boolean isSaveOrUpdated = customerService.saveOrUpdate(customerModel);
        if(isSaveOrUpdated) {
            attributes.addFlashAttribute("message", "updateSuccess");
        }
        // superAdminService.saveCompany(companyModel);
        return new RedirectView("./");
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("customerId") String customerId, Model model) {
        customerService.changeStatus(customerId, status);
        return "";
    }
}
