package lt.vtmc.foa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.foa.models.Menu;
import lt.vtmc.foa.payload.requests.EstablishmentUpdateRequest;
import lt.vtmc.foa.payload.requests.MenuInsertRequest;
import lt.vtmc.foa.payload.requests.MenuUpdateRequest;
import lt.vtmc.foa.payload.responses.EstablishmentResponse;
import lt.vtmc.foa.payload.responses.MenuResponse;
import lt.vtmc.foa.security.services.MenuService;

@CrossOrigin
@RestController
@RequestMapping("/api/menu")
public class MenuController {
	//api/establishments/{id}/menus
	private final MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
		
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MenuResponse insertMenu(@Valid @RequestBody MenuInsertRequest menuInsertRequest) {
		return this.menuService.saveMenu(menuInsertRequest);
	}
	
	@GetMapping
	public ResponseEntity<List<Menu>> getAllMenus(){
		return ResponseEntity.ok().body(this.menuService.getAllMenus());
	}
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public MenuResponse updateEstablishment(@RequestBody MenuUpdateRequest menuUpdateRequest) {
		return this.menuService.updateMenu(menuUpdateRequest);
	}
}
