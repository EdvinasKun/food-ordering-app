package lt.vtmc.foa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.foa.models.Dish;
import lt.vtmc.foa.payload.requests.DishInsertRequest;
import lt.vtmc.foa.payload.requests.DishUpdateRequest;
import lt.vtmc.foa.payload.responses.DishResponse;
import lt.vtmc.foa.security.services.DishService;

@CrossOrigin
@RestController
@RequestMapping("/api/dish")
public class DishController {

	private final DishService dishService;
	
	@Autowired
	public DishController(DishService dishService) {
		this.dishService = dishService;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DishResponse insertDish(@Valid @RequestBody DishInsertRequest dishInsertRequest) {
		return this.dishService.saveDish(dishInsertRequest);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DishResponse updateDish(@RequestBody DishUpdateRequest dishUpdateRequest, @PathVariable Long id) {
		return this.dishService.updateDish(id, dishUpdateRequest);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DishResponse deleteDish(@PathVariable String id) {
		return this.dishService.deleteDish(id);
	}
	@GetMapping
	public List<Dish> getAllDish() {
		return this.dishService.getAllDish();
	}
}
