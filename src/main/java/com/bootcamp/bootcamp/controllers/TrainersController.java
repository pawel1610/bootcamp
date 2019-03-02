package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TrainersController {
    @Autowired
    private TrainersService trainersService;

    @RequestMapping(value = "/trenerzy", method = RequestMethod.GET)
    public String getTrainers(Model model){
        model.addAttribute("trainersList", trainersService.getTrainers());
        return "trainers";
    }

}
