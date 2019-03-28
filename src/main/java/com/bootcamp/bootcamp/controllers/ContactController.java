package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.Contact;
import com.bootcamp.bootcamp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        Contact contact = new Contact();
        model.addAttribute(contact);
        return "contact";
    }

    @RequestMapping(value = "/sent", method = RequestMethod.POST)
    public String getMessage(@Valid @ModelAttribute Contact contact, BindingResult bindingResulat, Model model) {  //@Valid - okresla ze obiekt contact bedzie walidowany,
        // Binding przechwytuje wynik walidacji - binding musi byc po elemencie walidowanym
        // @ModelAttribute lapiemy caly model z formularza
        if (bindingResulat.hasErrors()) {
            List<ObjectError> errors = bindingResulat.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        } else {
            model.addAttribute("sentMessage", true);
            contactService.saveContact(contact);
        }
        return "contact";
    }

}
