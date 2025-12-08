package fr.nadir.koudri.ProxiBanque.infrastructure.repository;

import fr.nadir.koudri.ProxiBanque.domain.card.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<BankCard, Long> {}