package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Trainer;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TrainersService {

    public List<Trainer> getTrainers(){
        Trainer trener1 = new Trainer();
        trener1.setId(1);
        trener1.setName("Michal");
        trener1.setLastName("Kruczkowski");
        trener1.setSallary(200);


        Trainer trener2 = new Trainer();
        trener2.setId(2);
        trener2.setName("Marcin");
        trener2.setLastName("Warycha");
        trener2.setSallary(230);

        Trainer trener3 = new Trainer();
        trener3.setId(3);
        trener3.setName("Paweł");
        trener3.setLastName("Sasin");
        trener3.setSallary(150);

        List<Trainer> trainersList = new LinkedList<>();
        trainersList.add(trener1);
        trainersList.add(trener2);
        trainersList.add(trener3);

        return trainersList;
    }



}
