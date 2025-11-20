package com.example.Projet_Nadir_Koudri.domain.account;

import com.example.Projet_Nadir_Koudri.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public abstract class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private double balance;
    private LocalDate openingDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public abstract void withdraw(double amount);
}

