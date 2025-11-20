package com.example.Projet_Nadir_Koudri.infrastructure.repository;

import com.example.Projet_Nadir_Koudri.domain.advisor.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {}