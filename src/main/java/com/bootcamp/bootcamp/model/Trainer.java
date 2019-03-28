package com.bootcamp.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "{com.bootcamp.bootcamp.model.Trainer.name.NotBlank}")
    private String name;

    @NotEmpty(message = "{com.bootcamp.bootcamp.model.Trainer.lastName.NotEmpty}")
    private String lastName;


    @Min(value = 1, message = "{com.bootcamp.bootcamp.model.Trainer.salary.Min}")
    private int salary;

    @NotEmpty(message = "{com.bootcamp.bootcamp.model.Trainer.description.NotEmpty}")
    private String description;

    @Override
    public String toString() {
        return "Trener " + name + " " +
                lastName;
    }

}
