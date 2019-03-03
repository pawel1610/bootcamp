package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    public String contact(Model model){
        Contact contact = new Contact();
        model.addAttribute(contact);
//        model.addAttribute("sentMessage", false);
        return "contact";
    }

    @RequestMapping(value = "/wyslano", method = RequestMethod.POST)
    public String getMessage(@ModelAttribute Contact contact,Model model){  // @ModelAttribute lapiemy caly model z formularza
        model.addAttribute("sentMessage", true);
        return "contact";
    }



}
