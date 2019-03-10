package com.bootcamp.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private Course course; // tzw klucz obcy

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @Positive
    private int price;

    @Positive
    private int membersLimit;

    @ManyToOne
    @JoinColumn(name = "courseMode_id")
    private CourseMode courseMode; // tzw klucz obcy


    private boolean active;

}
