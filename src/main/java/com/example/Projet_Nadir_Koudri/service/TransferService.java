package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    public boolean transfer(Account from, Account to, double amount) {
        if (amount <= 0) return false;

        double oldBalance = from.getBalance();
        from.withdraw(amount);

        if (from.getBalance() != oldBalance) {
            to.deposit(amount);
            return true;
        }
        return false;
    }
}
