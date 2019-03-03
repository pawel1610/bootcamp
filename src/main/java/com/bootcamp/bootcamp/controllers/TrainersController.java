package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Controller
@RequestMapping("/trenerzy")

public class TrainersController {
    @Autowired
    private TrainersService trainersService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getTrainers(Model model){
        model.addAttribute("trainersList", trainersService.getTrainers());
        return "trainers";
    }

    @GetMapping("/{id}")
    public String showTrainer(@PathVariable(name = "id") int id, Model model){
        Optional<Trainer> trainer = trainersService.showTrainrerById(id);

        if (trainer.isPresent()){
        model.addAttribute("trainer", trainer.get());
        return  "trainerDetails";
        }else {
            return "trainers";
        }
    }
}
