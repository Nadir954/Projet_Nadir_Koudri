package com.example.Projet_Nadir_Koudri.web.controller;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.domain.account.CheckingAccount;
import com.example.Projet_Nadir_Koudri.domain.account.SavingAccount;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.AccountRepository;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository repo;
    private final ClientRepository clientRepo;

    public AccountController(AccountRepository repo, ClientRepository clientRepo) {
        this.repo = repo;
        this.clientRepo = clientRepo;
    }

    @GetMapping
    public List<Account> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Account find(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/checking")
    public CheckingAccount createChecking(@RequestBody CheckingAccount acc) {
        Client client = clientRepo.findById(acc.getClient().getId()).orElse(null);
        if (client == null) return null;

        acc.setClient(client);
        CheckingAccount saved = repo.save(acc);

        client.getAccounts().add(saved);
        clientRepo.save(client);

        return saved;
    }

    @PostMapping("/saving")
    public SavingAccount createSaving(@RequestBody SavingAccount acc) {
        Client client = clientRepo.findById(acc.getClient().getId()).orElse(null);
        if (client == null) return null;

        acc.setClient(client);
        SavingAccount saved = repo.save(acc);

        client.getAccounts().add(saved);
        clientRepo.save(client);

        return saved;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
