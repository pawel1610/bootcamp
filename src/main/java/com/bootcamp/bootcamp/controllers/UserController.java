package com.bootcamp.bootcamp.controllers;


import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CourseEditionService courseEditionService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/registeration", method = RequestMethod.GET)
    public String getRegisteration(@RequestParam(name = "id") Long id, Model model) {

        if (courseEditionService.getCourseEditionToEdit(id) != null){
            CourseEdition courseEdition = courseEditionService.getCourseEditionToEdit(id);
            User user = new User();
            model.addAttribute(user);
            model.addAttribute(courseEdition);
            return "addUserToCourseEdition";
        } else {
            model.addAttribute("editionIsNotActive", true);
            model.addAttribute(courseEditionService.getAllCourseEditionSortedtByStartDate());
            return "courses";
        }
    }

    @PostMapping("/saveUser/{id}")
    public String saveUserToCourseEdition(@Valid @ModelAttribute User user, BindingResult blindingResult,
                                          @PathVariable(name = "id") Long id,Model model) {
        if (blindingResult.hasErrors()) {
            List<ObjectError> errors = blindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            CourseEdition courseEdition = courseEditionService.getCourseEditionToEdit(id);
            model.addAttribute(courseEdition);
            return "addUserToCourseEdition";
        } else{
            userService.saveUser(user);
            model.addAttribute(courseEditionService.getAllCourseEditionSortedtByStartDate());
            return "userPanel";
        }

    }
    @GetMapping("/userPanel")
    public String showUserPanel() {
        return "userPanel";
    }
}
