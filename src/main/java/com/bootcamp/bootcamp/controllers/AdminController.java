package com.bootcamp.bootcamp.controllers;


import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "trainersAdmin";
    }

    @GetMapping("/addTrainer")
    public String getAddTrainer(Model model){
        Trainer trainer = new Trainer();
        model.addAttribute(trainer);
        return "addNewTrainer";
    }

    @PostMapping("/saveTrainer")
    public String saveTrainer(@ModelAttribute Trainer trainer,Model model){
        if(trainer.getId()> 0){
            model.addAttribute("trainerIsChanged", true);
        }else {
            model.addAttribute("trainerIsAdded", true);
        }
        trainersService.saveTrainer(trainer);
        model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName()); /// zdublowana funkcja ???????????
//        return "redirect:trenerzy";
        return "trainersAdmin";
    }
    @GetMapping("/editTrainer")
    public String editTrainer(@RequestParam(name = "id") Long id,Model model){
        Trainer trainer = trainersService.getTrainerToEdit(id);
        model.addAttribute(trainer);
        return "addNewTrainer";
    }

    @GetMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam(name = "id") Long id,Model model){
        trainersService.deletTrainer(id);
        model.addAttribute("trainerIsDeleted", true);
        model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName()); /// zdublowana funkcja ???????????
//        return "redirect:trenerzy";
        return "trainersAdmin";
    }



}
