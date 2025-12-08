package fr.nadir.koudri.ProxiBanque.service;

import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import fr.nadir.koudri.ProxiBanque.domain.account.CheckingAccount;
import fr.nadir.koudri.ProxiBanque.domain.account.SavingAccount;
import fr.nadir.koudri.ProxiBanque.domain.agency.Agency;
import fr.nadir.koudri.ProxiBanque.domain.client.Client;
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
