package fr.nadir.koudri.ProxiBanque.service;

import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import fr.nadir.koudri.ProxiBanque.infrastructure.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final AccountRepository repo;

    public TransferService(AccountRepository repo) {
        this.repo = repo;
    }

    public boolean transfer(Long fromId, Long toId, double amount) {

        if (amount <= 0) return false;

        Account from = repo.findById(fromId).orElse(null);
        Account to = repo.findById(toId).orElse(null);

        if (from == null || to == null)
            return false;

        double oldBalance = from.getBalance();

        from.withdraw(amount);

        if (from.getBalance() == oldBalance)
            return false;

        to.deposit(amount);

        repo.save(from);
        repo.save(to);

        return true;
    }
}
