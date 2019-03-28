package com.bootcamp.bootcamp.controllers;


import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.service.CourseRegisterationService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @Autowired
    private CourseRegisterationService courseRegisterationService;

    @Autowired
    private UserService userService;

    @GetMapping("/userPanel")
    public String showUserPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByEmail(authentication.getName());
        model.addAttribute("listOfUserCourses", courseRegisterationService.getListOfUserCourses(currentUser));
        return "userPanel";
    }
}
