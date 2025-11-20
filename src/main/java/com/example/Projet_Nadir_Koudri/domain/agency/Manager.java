package com.example.Projet_Nadir_Koudri.domain.agency;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Manager {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
}
