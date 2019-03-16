package com.bootcamp.bootcamp.controllers;


import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    private CourseEditionService courseEditionService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/kursy", method = RequestMethod.GET)
    public String getCourses(Model model) {
        model.addAttribute(courseEditionService.getAllCourseEditionSortedtByStartDate());
        return "courses";
    }
}
