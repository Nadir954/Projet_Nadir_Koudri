package fr.nadir.koudri.ProxiBanque.infrastructure.repository;

import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}