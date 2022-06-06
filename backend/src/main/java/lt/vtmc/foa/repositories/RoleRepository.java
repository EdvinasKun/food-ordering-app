package lt.vtmc.foa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.foa.models.ERole;
import lt.vtmc.foa.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
