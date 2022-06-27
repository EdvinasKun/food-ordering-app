package lt.vtmc.foa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.foa.models.Establishment;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{
	
	
	Optional<Establishment> findByEstablishmentName(String es);
}
