package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findByname(String firstname);

}
