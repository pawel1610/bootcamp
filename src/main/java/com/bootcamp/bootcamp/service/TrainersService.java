package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Trainer;
import com.bootcamp.bootcamp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public List<Trainer> getTrainersSortedByLastName(){
        List<Trainer> trainerListSortedByLastName = trainerRepository.findAllByOrderByLastNameAsc();
        return trainerListSortedByLastName;
    }



    public void saveTrainer(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public Trainer getTrainerToEdit(Long id){
        Optional<Trainer> trainerOptional= trainerRepository.findById(id);
        Trainer trainerToEdit = trainerOptional.get();
        return trainerToEdit;
    }
    public Trainer getTrainerByLastName(String lastName){
        Trainer trainerByLastName= trainerRepository.getTrainerByLastName(lastName);
        return trainerByLastName;
    }

    public void deletTrainer(Long id){
        trainerRepository.deleteById(id);
    }




}
