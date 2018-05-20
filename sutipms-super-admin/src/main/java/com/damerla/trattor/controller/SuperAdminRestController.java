package com.damerla.trattor.controller;

import com.damerla.trattor.model.CompanyFilterModel;
import com.damerla.trattor.model.DataTablePaginationModel;
import com.damerla.trattor.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SuperAdminService superAdminService;

    @GetMapping("/home")
    public DataTablePaginationModel getCompanyList(Model model){
        DataTablePaginationModel dataTablePaginationModel = superAdminService.getCompanyList();
    return dataTablePaginationModel;
    }

    @PostMapping("/filter")
    public DataTablePaginationModel getFilterCompanyList(@ModelAttribute CompanyFilterModel companyFilterModel){
        return null;
    }
}
