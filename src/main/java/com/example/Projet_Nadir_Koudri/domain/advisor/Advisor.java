package com.example.Projet_Nadir_Koudri.domain.advisor;

import com.example.Projet_Nadir_Koudri.domain.agency.Agency;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Advisor {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Agency agency;

    @OneToMany(mappedBy = "advisor")
    private List<Client> clients = new ArrayList<>();
}
