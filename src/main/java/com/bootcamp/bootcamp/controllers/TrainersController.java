package com.bootcamp.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TrainersController {
    @RequestMapping(value = "/trenerzy", method = RequestMethod.GET)
    public String getTrainers(){
        return "trainers";
    }



}
