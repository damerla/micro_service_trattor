package com.damerla.trattor.controller;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.model.WorkModel;
import com.damerla.trattor.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @GetMapping("/")
    public String home(Model model) {
        return "";
    }

    @PostMapping("/")
    public String userHome(Model model) {
        return "";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute WorkModel workModel, Model model) {
        workService.saveOrUpdate(workModel);
        return "";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("status") String status, @RequestParam("workId") String workId, Model model) {
        workService.changeStatus(workId, status);
        return "";
    }
}
