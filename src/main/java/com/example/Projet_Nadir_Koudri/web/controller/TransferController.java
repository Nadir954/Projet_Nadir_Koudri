package com.example.Projet_Nadir_Koudri.web.controller;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.AccountRepository;
import com.example.Projet_Nadir_Koudri.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService service;
    private final AccountRepository repo;

    public TransferController(TransferService service, AccountRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping
    public boolean transfer(@RequestParam Long fromId,
                            @RequestParam Long toId,
                            @RequestParam double amount) {

        Account from = repo.findById(fromId).orElse(null);
        Account to = repo.findById(toId).orElse(null);

        if (from == null || to == null) return false;

        return service.transfer(from, to, amount);
    }
}
