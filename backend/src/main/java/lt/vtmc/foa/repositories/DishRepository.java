package lt.vtmc.foa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.foa.models.Dish;
@Repository
public interface DishRepository extends JpaRepository <Dish, Long>{

	List<Dish> findByMenuId(Long id);
}
