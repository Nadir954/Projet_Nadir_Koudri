package fr.nadir.koudri.ProxiBanque.web.controller;

import fr.nadir.koudri.ProxiBanque.domain.client.Client;
import fr.nadir.koudri.ProxiBanque.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client create(@RequestBody Client c) {
        return service.create(c);
    }

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client find(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
