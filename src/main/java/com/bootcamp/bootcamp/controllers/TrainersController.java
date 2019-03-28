package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.TrainersService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TrainersController {

    @Autowired
    private TrainersService trainersService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseEditionService courseEditionService;

    @RequestMapping(value = "/trainers", method = RequestMethod.GET)
    public String getTrainers(Model model) {
        model.addAttribute("trainersList", trainersService.getTrainers());
        return "trainers";
    }

    @GetMapping("/trainers/{id}")
    public String showTrainer(@PathVariable(name = "id") int id, Model model) {
        Optional<Trainer> trainer = trainersService.showTrainrerById(id);
        if (trainer.isPresent()) {
            model.addAttribute("trainer", trainer.get());
            return "trainerDetails";
        } else {
            return "trainers";
        }
    }

    @GetMapping("/trainerPanel")
    public String trainerPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentTrainer = userService.getUserByEmail(authentication.getName());
        Trainer trainer = trainersService.getTrainerByLastName(currentTrainer.getLastName());
        model.addAttribute("courseEditionList",
                courseEditionService.getCourseEditionsByTrainer(trainer));
        return "trainerPanel";
    }


}
