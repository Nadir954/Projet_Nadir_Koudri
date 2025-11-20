package com.example.Projet_Nadir_Koudri.domain.account;

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

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public abstract void withdraw(double amount);
}
