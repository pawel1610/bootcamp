package com.bootcamp.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    public String getContact(){

        return "contact";
    }

    @RequestMapping(value = "/wyslano", method = RequestMethod.GET)
    public String getMessage(){
        return "wyslano";
    }
}
