package com.example.Projet_Nadir_Koudri.infrastructure.repository;

import com.example.Projet_Nadir_Koudri.domain.agency.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
