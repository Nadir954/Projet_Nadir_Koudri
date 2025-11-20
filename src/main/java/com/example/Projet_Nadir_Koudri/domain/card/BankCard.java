package com.example.Projet_Nadir_Koudri.domain.card;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public abstract class BankCard {

    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private LocalDate expirationDate;
    private boolean active = true;

    public abstract double getPaymentLimit();
    public abstract double getWithdrawalLimit();

    public void deactivate() {
        active = false;
    }
}
