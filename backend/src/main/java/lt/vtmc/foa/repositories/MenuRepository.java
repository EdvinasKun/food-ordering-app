package lt.vtmc.foa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.foa.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{

	Optional<Menu> findByMenuName(String name);

	//Optional<Menu> findById(String menuId);

	Menu getById(Long id);
}
