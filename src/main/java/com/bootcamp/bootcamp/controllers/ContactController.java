package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.Contact;
import com.bootcamp.bootcamp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    public String contact(Model model){
        Contact contact = new Contact();
        model.addAttribute(contact);
        return "contact";
    }

    @RequestMapping(value = "/wyslano", method = RequestMethod.POST)
    public String getMessage(@ModelAttribute Contact contact,Model model){  // @ModelAttribute lapiemy caly model z formularza
        model.addAttribute("sentMessage", true);
        contactService.saveContact(contact);
        return "contact";
    }

}
