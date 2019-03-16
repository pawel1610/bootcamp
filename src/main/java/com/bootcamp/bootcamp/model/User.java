package com.bootcamp.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @NotNull
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$", message = "Błędny format")
    private String phone;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @NotEmpty
    private String password;

}
