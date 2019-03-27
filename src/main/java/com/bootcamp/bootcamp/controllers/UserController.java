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



    @GetMapping("/userPanel")
    public String showUserPanel() {
        return "userPanel";
    }
}
