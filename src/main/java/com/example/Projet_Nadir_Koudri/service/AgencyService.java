package com.example.Projet_Nadir_Koudri.service;

import com.example.Projet_Nadir_Koudri.domain.agency.Agency;
import com.example.Projet_Nadir_Koudri.domain.client.Client;
import com.example.Projet_Nadir_Koudri.infrastructure.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepo;

    public AgencyService(AgencyRepository agencyRepo) {
        this.agencyRepo = agencyRepo;
    }

    public Agency create(Agency a) {
        return agencyRepo.save(a);
    }

    public Agency findById(Long id) {
        return agencyRepo.findById(id).orElse(null);
    }

    public List<Agency> findAll() {
        return agencyRepo.findAll();
    }

    public Agency update(Long id, Agency agency) {
        agency.setId(id);
        return agencyRepo.save(agency);
    }

    public void assignClient(Agency agency, Client client) {
        agency.getClients().add(client);
        agencyRepo.save(agency);
    }
}
