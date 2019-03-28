package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private CourseEditionService courseEditionService;

    @Autowired
    private UserService userService;

    @GetMapping("/userPanel")
    public String showUserPanel() {
        return "userPanel";
    }
}
