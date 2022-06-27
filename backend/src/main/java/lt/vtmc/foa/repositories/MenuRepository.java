package lt.vtmc.foa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.foa.models.Dish;
import lt.vtmc.foa.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

//	findByEstablishmentId()
	List<Menu> getAllByEstablishmentId(Long id);
}
