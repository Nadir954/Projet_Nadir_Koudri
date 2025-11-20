package com.example.Projet_Nadir_Koudri.web.controller;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.domain.account.CheckingAccount;
import com.example.Projet_Nadir_Koudri.domain.account.SavingAccount;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository repo;

    public AccountController(AccountRepository repo) {
        this.repo = repo;
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
        return repo.save(acc);
    }

    @PostMapping("/saving")
    public SavingAccount createSaving(@RequestBody SavingAccount acc) {
        return repo.save(acc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
