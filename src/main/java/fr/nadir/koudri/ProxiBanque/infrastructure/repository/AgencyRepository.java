package fr.nadir.koudri.ProxiBanque.infrastructure.repository;

import fr.nadir.koudri.ProxiBanque.domain.agency.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {}