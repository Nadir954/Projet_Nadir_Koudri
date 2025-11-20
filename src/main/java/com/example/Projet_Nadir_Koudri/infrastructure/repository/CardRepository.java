package com.example.Projet_Nadir_Koudri.infrastructure.repository;

import com.example.Projet_Nadir_Koudri.domain.card.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<BankCard, Long> {}