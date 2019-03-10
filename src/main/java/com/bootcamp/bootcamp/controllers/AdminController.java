package com.bootcamp.bootcamp.controllers;


import com.bootcamp.bootcamp.model.Course;
import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.service.CourseService;
import com.bootcamp.bootcamp.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
public class AdminController {
    @Autowired
    private TrainersService trainersService;

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/trenerzy")
    public String getTrenerzyAdmin(Model model) {
        model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName());
        return "trainersAdmin";
    }

    @GetMapping("/addTrainer")
    public String getAddTrainer(Model model) {
        Trainer trainer = new Trainer();
        model.addAttribute(trainer);
        return "addNewTrainer";
    }

    @PostMapping("/saveTrainer")
    public String saveTrainer(@Valid @ModelAttribute Trainer trainer, BindingResult bindingResulat, Model model) {
        if (bindingResulat.hasErrors()) {
            List<ObjectError> errors = bindingResulat.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "addNewTrainer";
        } else {
            if (trainer.getId() > 0) {
                model.addAttribute("trainerIsChanged", true);
            } else {
                model.addAttribute("trainerIsAdded", true);
            }
            trainersService.saveTrainer(trainer);
            model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName()); /// zdublowana funkcja ???????????
            return "trainersAdmin";
        }
//        return "redirect:trenerzy";

    }

    @GetMapping("/editTrainer")
    public String editTrainer(@RequestParam(name = "id") Long id, Model model) {
        Trainer trainer = trainersService.getTrainerToEdit(id);
        model.addAttribute(trainer);
        return "addNewTrainer";
    }

    @GetMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam(name = "id") Long id, Model model) {
        trainersService.deletTrainer(id);
        model.addAttribute("trainerIsDeleted", true);
        model.addAttribute("trainersListSortedByLastName", trainersService.getTrainersSortedByLastName()); /// zdublowana funkcja ???????????
//        return "redirect:trenerzy";
        return "trainersAdmin";
    }

    @GetMapping("/kursy")
    public String getCoursesAdmin(Model model) {
        model.addAttribute("courseList", courseService.getAllCourses());
        return "coursesAdmin";
    }

    @GetMapping("/addCourse")
    public String getAddCourse(Model model) {
        Course course = new Course();
        model.addAttribute(course);
        return "addNewCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@Valid @ModelAttribute Course course, BindingResult bindingResulat, Model model) {
        if (bindingResulat.hasErrors()) {
            List<ObjectError> errors = bindingResulat.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "addNewTrainer";
        } else {
            if (course.getId() > 0) {
                model.addAttribute("courseIsChanged", true);
            } else {
                model.addAttribute("courseIsAdded", true);
            }

            courseService.saveCourse(course);
            model.addAttribute("courseList", courseService.getAllCourses());
            return "coursesAdmin";
        }

    }

    @GetMapping("/editCourse")
    public String editCourse(@RequestParam(name = "id") Long id, Model model) {
        Course course = courseService.getCourseToEdit(id);
        model.addAttribute(course);
        return "addNewCourse";
    }

}
