package com.bootcamp.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Course course; // tzw klucz obcy


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Positive
    private int price;

    @Positive
    private int membersLimit;

    @ManyToOne
    @JoinColumn(name = "courseMode_id")
    @NotNull
    private CourseMode courseMode; // tzw klucz obcy

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    @NotNull
    private Trainer trainer;


    private boolean active;



    @Override
    public String toString() {
        return "CourseEdition{" +
                "id=" + id +
                ", course=" + course +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", membersLimit=" + membersLimit +
                ", courseMode=" + courseMode +
                ", active=" + active +
                '}';
    }
}
