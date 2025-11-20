package com.example.Projet_Nadir_Koudri.web.controller;

import com.example.Projet_Nadir_Koudri.domain.advisor.Advisor;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import com.example.Projet_Nadir_Koudri.service.AdvisorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {

    private final AdvisorService service;

    public AdvisorController(AdvisorService service) {
        this.service = service;
    }

    @PostMapping
    public Advisor create(@RequestBody Advisor a) {
        return service.create(a);
    }

    @GetMapping
    public List<Advisor> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Advisor find(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Advisor update(@PathVariable Long id, @RequestBody Advisor a) {
        return service.update(id, a);
    }

    @PostMapping("/{advisorId}/wealth")
    public boolean isWealthy(@PathVariable Long advisorId, @RequestBody Client c) {
        return service.isWealthy(c);
    }
}
