package com.bootcamp.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoursesController {
    @RequestMapping(value = "/kursy", method = RequestMethod.GET)
    public String getCourses(){
        return "courses";
    }
}
