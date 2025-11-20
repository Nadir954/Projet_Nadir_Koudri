package com.example.Projet_Nadir_Koudri.domain.agency;

import com.example.Projet_Nadir_Koudri.domain.advisor.Advisor;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Agency {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 5, max = 5)
    @Column(unique = true)
    private String code;

    private LocalDate creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Manager manager;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Advisor> advisors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();
}
