package fr.nadir.koudri.ProxiBanque.domain.card;

import jakarta.persistence.Entity;

@Entity
public class VisaPremierCard extends BankCard {

    @Override
    public double getPaymentLimit() {
        return 8000;
    }

    @Override
    public double getWithdrawalLimit() {
        return 2000;
    }
}
