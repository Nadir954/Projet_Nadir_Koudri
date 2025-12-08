package fr.nadir.koudri.ProxiBanque.service;

import fr.nadir.koudri.ProxiBanque.domain.client.Client;
import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import fr.nadir.koudri.ProxiBanque.infrastructure.repository.AccountRepository;
import fr.nadir.koudri.ProxiBanque.infrastructure.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepo;
    private final AccountRepository accountRepo;

    public ClientService(ClientRepository clientRepo,
                         AccountRepository accountRepo) {

        this.clientRepo = clientRepo;
        this.accountRepo = accountRepo;
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
        Client existing = findById(id);
        if (existing == null) return null;

        c.setId(id);
        return clientRepo.save(c);
    }

    public void delete(Long id) {
        Client client = findById(id);
        if (client == null) return;

        client.getCards().forEach(card -> card.setActive(false));

        for (Account account : client.getAccounts()) {
            accountRepo.delete(account);
        }

        clientRepo.delete(client);
    }
}
