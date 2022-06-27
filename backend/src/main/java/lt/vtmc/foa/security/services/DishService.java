package lt.vtmc.foa.security.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.vtmc.foa.models.Dish;
import lt.vtmc.foa.payload.requests.DishInsertRequest;
import lt.vtmc.foa.payload.requests.DishUpdateRequest;
import lt.vtmc.foa.payload.responses.DishResponse;
import lt.vtmc.foa.repositories.DishRepository;
import lt.vtmc.foa.repositories.MenuRepository;

@Service
public class DishService {

	private final MenuRepository menuRepository;
	private final DishRepository dishRepository;
	
	public DishService(MenuRepository menuRepository, DishRepository dishRepository) {
		this.menuRepository = menuRepository;
		this.dishRepository = dishRepository;
	}
	
	public DishResponse saveDish(DishInsertRequest dishRequest) {
		
		Dish dish = new Dish(
				
				);
		dish.setDishName(dishRequest.getDishName());
		dish.setMenu(menuRepository.getById(Long.valueOf(dishRequest.getMenuId())));
		dishRepository.save(dish);
		return new DishResponse(
				dish.getId().toString(),
				dishRequest.getDishName(),
				dish.getMenu().getMenuName()
				);
	}
	public DishResponse updateDish(Long id, DishUpdateRequest dishUpdateRequest) {
		
		Dish updatingDish = dishRepository.getById(id);
		
		updatingDish.setDishName(dishUpdateRequest.getDishName());
		updatingDish.setMenu(menuRepository.getById(Long.valueOf(dishUpdateRequest.getMenuId())));;
		dishRepository.save(updatingDish);
		return new DishResponse(
				updatingDish.getId().toString(),
				updatingDish.getDishName(),
				updatingDish.getMenu().getMenuName()
				);
	}
	public DishResponse deleteDish(String id) {
		dishRepository.delete(dishRepository.getById(Long.valueOf(id)));
		return null;
	}
	public List<Dish> getAllDish(){
		return dishRepository.findAll();
	}
	
}
