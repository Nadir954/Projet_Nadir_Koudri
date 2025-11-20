package com.example.Projet_Nadir_Koudri.domain.account;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {

    private double overdraftLimit = 1000.0;

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        double newBalance = getBalance() - amount;
        if (newBalance >= -overdraftLimit) {
            setBalance(newBalance);
        }
    }
}
