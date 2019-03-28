package com.bootcamp.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-summary.html  --  lista dostepnych validacji
    @NotEmpty(message = "Proszę podac swoje imie")
    private String name;

    @NotEmpty(message = "{com.bootcamp.bootcamp.model.Contact.lastName.NotEmpty}")
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    private String message;

    private LocalDateTime data;

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
