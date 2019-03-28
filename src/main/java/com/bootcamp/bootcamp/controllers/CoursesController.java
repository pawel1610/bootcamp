package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoursesController {

    @Autowired
    private CourseEditionService courseEditionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String getCourses(Model model) {
        model.addAttribute(courseEditionService.getAllCourseEditionSortedtByStartDate());
        return "courses";
    }
}
