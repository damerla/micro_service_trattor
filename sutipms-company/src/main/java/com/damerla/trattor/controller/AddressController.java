package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.model.DataTablePaginationModel;
import com.damerla.trattor.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("addressModel",new AddressModel());
        return "company/address";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public RedirectView create(@ModelAttribute AddressModel addressModel, Model model,  RedirectAttributes attributes) {
        Boolean isSaveOrUpdated = addressService.saveOrUpdate(addressModel);
        if(isSaveOrUpdated) {
            attributes.addFlashAttribute("message", "updateSuccess");
        }
            // superAdminService.saveCompany(companyModel);
            return new RedirectView("./");
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("addressId") String addressId, Model model) {
        addressService.changeStatus(addressId, status);
        return "";
    }

    @GetMapping("/address")
    public @ResponseBody DataTablePaginationModel  getAddress(Model model){
        DataTablePaginationModel dataTablePaginationModel = addressService.getAddress();
        return dataTablePaginationModel;

    }
}
