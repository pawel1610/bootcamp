package com.bootcamp.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private int sallary;
    private String description;



    @Override
    public String toString() {
        return "Trener " + name + " " +
                lastName + " zarabia " + sallary ;
    }


}
