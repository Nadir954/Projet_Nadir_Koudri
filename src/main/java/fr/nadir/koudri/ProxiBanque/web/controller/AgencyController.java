package fr.nadir.koudri.ProxiBanque.web.controller;

import fr.nadir.koudri.ProxiBanque.domain.agency.Agency;
import fr.nadir.koudri.ProxiBanque.service.AgencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies")
public class AgencyController {

    private final AgencyService service;

    public AgencyController(AgencyService service) {
        this.service = service;
    }

    @PostMapping
    public Agency create(@RequestBody Agency a) {
        return service.create(a);
    }

    @GetMapping
    public List<Agency> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Agency find(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Agency update(@PathVariable Long id, @RequestBody Agency a) {
        return service.update(id, a);
    }
}
