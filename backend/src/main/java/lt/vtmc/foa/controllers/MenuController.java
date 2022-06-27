package lt.vtmc.foa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import lt.vtmc.foa.models.Menu;
import lt.vtmc.foa.payload.requests.MenuInsertRequest;
import lt.vtmc.foa.payload.requests.MenuUpdateRequest;
import lt.vtmc.foa.payload.responses.MenuResponse;
import lt.vtmc.foa.security.services.MenuService;

@CrossOrigin
@RestController
@RequestMapping("/api/menu")
public class MenuController {

	private final MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MenuResponse insertMenu(@Valid @RequestBody MenuInsertRequest menuInsertRequest) {
		return this.menuService.saveMenu(menuInsertRequest);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MenuResponse updateMenu(@RequestBody MenuUpdateRequest menuUpdateRequest, @PathVariable Long id) {
		return this.menuService.updateMenu(id, menuUpdateRequest);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MenuResponse deleteMenu(@PathVariable String id) {
		return this.menuService.deleteMenu(id);
	}
	@GetMapping
	public List<Menu> getAllMenus() {
		return this.menuService.getAllMenu();
	}
	@GetMapping("/{id}")
	public List<Menu> getAllMenusId(@PathVariable String id) {
		return this.menuService.getAllMenuById(id);
	}
}
