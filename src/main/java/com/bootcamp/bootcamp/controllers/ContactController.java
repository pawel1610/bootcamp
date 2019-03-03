package com.bootcamp.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    public String getContact(){
        return "contact";
    }

    @RequestMapping(value = "/wyslano", method = RequestMethod.GET)
    public String getMessage(@RequestParam(name = "imie", defaultValue = "Nieznajomy") String firstName,
                             @RequestParam(name = "nazwisko", defaultValue = "Nieznajomy") String lastName,
                             @RequestParam(name = "wiadomosc") String message,
                             Model model){

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("message", message);
        return "sent";
    }


}
