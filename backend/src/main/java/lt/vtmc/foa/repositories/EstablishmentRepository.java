package lt.vtmc.foa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.foa.models.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{
	
	
	Optional<Establishment> findByEstablishmentName(String es);
}
