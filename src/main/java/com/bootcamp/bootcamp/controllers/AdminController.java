package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
public class AdminController {
    @Autowired
    private TrainersService trainersService;

    @GetMapping("")
    public String getAdmin(){
        return "admin";
    }
    @GetMapping("/trenerzy")

    public String getTrenerzyAdmin(Model model){

        model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName());
        return "trenerzyAdmin";
    }
}
