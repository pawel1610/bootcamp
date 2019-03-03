package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainersService {
    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getTrainers(){

        List<Trainer> trainersList = trainerRepository.findAll();
        return trainersList;
    }

    public Optional<Trainer> showTrainrerById(long id){
        return trainerRepository.findById(id);

    }



}
