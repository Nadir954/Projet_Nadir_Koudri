package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.domain.agency.Agency;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public boolean isAgencyCompliant(Agency agency) {

        for (Client c : agency.getClients()) {
            if (c.getCheckingAccount() != null &&
                    c.getCheckingAccount().getBalance() < -5000)
                return false;

            if (c.getSavingAccount() != null &&
                    c.getSavingAccount().getBalance() < -5000)
                return false;
        }

        return true;
    }
}
