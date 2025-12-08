package fr.nadir.koudri.ProxiBanque.service;

import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import fr.nadir.koudri.ProxiBanque.domain.advisor.Advisor;
import fr.nadir.koudri.ProxiBanque.domain.client.Client;
import fr.nadir.koudri.ProxiBanque.infrastructure.repository.AdvisorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepo;

    public AdvisorService(AdvisorRepository advisorRepo) {
        this.advisorRepo = advisorRepo;
    }

    public Advisor create(Advisor a) {
        return advisorRepo.save(a);
    }

    public Advisor findById(Long id) {
        return advisorRepo.findById(id).orElse(null);
    }

    public List<Advisor> findAll() {
        return advisorRepo.findAll();
    }

    public Advisor update(Long id, Advisor advisor) {
        advisor.setId(id);
        return advisorRepo.save(advisor);
    }

    public boolean isWealthy(Client c) {
        double total = 0;

        if (c.getAccounts() != null) {
            for (Account account : c.getAccounts()) {
                total += account.getBalance();
            }
        }

        return total > 500000;
    }
}
