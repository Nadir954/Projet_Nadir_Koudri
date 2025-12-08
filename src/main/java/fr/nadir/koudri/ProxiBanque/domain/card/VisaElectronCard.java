package fr.nadir.koudri.ProxiBanque.domain.card;

import jakarta.persistence.Entity;

@Entity
public class VisaElectronCard extends BankCard {

    @Override
    public double getPaymentLimit() {
        return 2000;
    }

    @Override
    public double getWithdrawalLimit() {
        return 500;
    }
}
