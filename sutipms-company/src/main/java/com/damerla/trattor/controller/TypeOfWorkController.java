package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.model.TypeOfWorkModel;
import com.damerla.trattor.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/typeOfWork")
public class TypeOfWorkController {

    @Autowired
    private TypeOfWorkService typeOfWorkService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute TypeOfWorkModel typeOfWorkModel, Model model) {
        typeOfWorkService.saveOrUpdate(typeOfWorkModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("typeOfWorkId") String typeOfWorkId, Model model) {
        typeOfWorkService.changeStatus(typeOfWorkId, status);
        return "";
    }
}
