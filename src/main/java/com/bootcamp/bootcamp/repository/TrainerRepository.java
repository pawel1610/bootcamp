package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> findByname(String firstname);

    List<Trainer> findAllByOrderByLastNameAsc();

    @Query("SELECT t From Trainer t where t.lastName=:lastName order by lastName ASC")
    List<Trainer> getTrainersOrderByLastNameAsc(@Param("lastName") String lastName);


}

