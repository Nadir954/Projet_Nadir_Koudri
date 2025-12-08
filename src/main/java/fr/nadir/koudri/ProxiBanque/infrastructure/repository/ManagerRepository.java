package fr.nadir.koudri.ProxiBanque.infrastructure.repository;

import fr.nadir.koudri.ProxiBanque.domain.agency.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
