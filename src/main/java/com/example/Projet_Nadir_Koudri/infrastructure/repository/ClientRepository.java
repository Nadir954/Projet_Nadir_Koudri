package com.example.Projet_Nadir_Koudri.infrastructure.repository;

import com.example.Projet_Nadir_Koudri.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}