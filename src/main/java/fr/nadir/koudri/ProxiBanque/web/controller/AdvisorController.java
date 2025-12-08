package fr.nadir.koudri.ProxiBanque.web.controller;

import fr.nadir.koudri.ProxiBanque.domain.advisor.Advisor;
import fr.nadir.koudri.ProxiBanque.domain.client.Client;
import fr.nadir.koudri.ProxiBanque.service.AdvisorService;
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
