package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.domain.account.CheckingAccount;
import com.example.Projet_Nadir_Koudri.domain.account.SavingAccount;
import com.example.Projet_Nadir_Koudri.domain.agency.Agency;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public boolean isAgencyCompliant(Agency agency) {

        for (Client c : agency.getClients()) {

            for (Account account : c.getAccounts()) {

                if (account instanceof CheckingAccount checking) {
                    if (checking.getBalance() < -5000) {
                        return false;
                    }
                }

                if (account instanceof SavingAccount saving) {
                    if (saving.getBalance() < 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
