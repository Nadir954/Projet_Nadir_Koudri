package com.example.Projet_Nadir_Koudri.web.controller;

import com.example.Projet_Nadir_Koudri.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public boolean transfer(@RequestParam Long fromId,
                            @RequestParam Long toId,
                            @RequestParam double amount) {
        return service.transfer(fromId, toId, amount);
    }
}
