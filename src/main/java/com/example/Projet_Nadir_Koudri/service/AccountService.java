package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public List<Account> findAll() {
        return repo.findAll();
    }

    public Account save(Account a) {
        return repo.save(a);
    }

    public void delete(Account a) {
        repo.delete(a);
    }
}
