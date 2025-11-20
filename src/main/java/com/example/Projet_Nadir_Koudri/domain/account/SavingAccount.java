package com.example.Projet_Nadir_Koudri.domain.account;

import jakarta.persistence.Entity;

@Entity
public class SavingAccount extends Account {

    private double annualInterestRate = 0.03;

    public void applyMonthlyInterest() {
        double rate = annualInterestRate / 12;
        setBalance(getBalance() * (1 + rate));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        double newBalance = getBalance() - amount;
        if (newBalance >= 0) {
            setBalance(newBalance);
        }
    }
}
