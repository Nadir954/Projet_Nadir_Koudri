package fr.nadir.koudri.ProxiBanque.infrastructure.repository;

import fr.nadir.koudri.ProxiBanque.domain.advisor.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {}