package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.domain.advisor.Advisor;
import com.example.Projet_Nadir_Koudri.domain.agency.Agency;
import com.example.Projet_Nadir_Koudri.domain.card.BankCard;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepo;
    private final AccountRepository accountRepo;
    private final AdvisorRepository advisorRepo;
    private final AgencyRepository agencyRepo;

    public ClientService(ClientRepository clientRepo,
                         AccountRepository accountRepo,
                         AdvisorRepository advisorRepo,
                         AgencyRepository agencyRepo) {

        this.clientRepo = clientRepo;
        this.accountRepo = accountRepo;
        this.advisorRepo = advisorRepo;
        this.agencyRepo = agencyRepo;
    }

    public Client create(Client c) {
        return clientRepo.save(c);
    }

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public Client update(Long id, Client c) {
        c.setId(id);
        return clientRepo.save(c);
    }

    public void delete(Long id) {
        Client client = findById(id);
        if (client == null) return;

        if (client.getCheckingAccount() != null)
            accountRepo.delete(client.getCheckingAccount());

        if (client.getSavingAccount() != null)
            accountRepo.delete(client.getSavingAccount());

        for (BankCard card : client.getCards())
            card.setActive(false);

        for (Advisor advisor : advisorRepo.findAll())
            advisor.getClients().remove(client);

        for (Agency agency : agencyRepo.findAll())
            agency.getClients().remove(client);

        clientRepo.delete(client);
    }
}
