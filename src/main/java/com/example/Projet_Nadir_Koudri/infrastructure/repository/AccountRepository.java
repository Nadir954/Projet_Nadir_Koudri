package com.example.Projet_Nadir_Koudri.infrastructure.repository;

import com.example.Projet_Nadir_Koudri.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}