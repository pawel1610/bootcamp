package com.bootcamp.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "bootcamp", method = RequestMethod.GET) - dodajemy gdy mamy wspolna czesc w adresie, zeby nei pisac ponizej
public class HomeController {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/") //skrocona wersja
    public String getHome(@RequestParam(name = "imie", defaultValue = "Nieznajomy") String firstName,
                          @RequestParam(name = "nazwisko", defaultValue = "Nieznajomy") String lastName,
                          @RequestParam (defaultValue = "10") int wiek, //mozna nie dwfinowiac name gdy nazwa i nazwa w programie ma byc taka sama
                          Model model) {
//        System.out.println("Witaj " + firstName + " " + lastName + " wiek " + wiek);
//        if (wiek>20){return "redirect:o-nas";//przekierowanie na inna strone
        // return "forward:o-nas";//przekierowanie na inna strone,ale nie zmienia sie adres
//    }

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "home";
    }
    @RequestMapping(value = "/o-nas", method = RequestMethod.GET)
    public String getAbout(){
        return "about";
    }
}
