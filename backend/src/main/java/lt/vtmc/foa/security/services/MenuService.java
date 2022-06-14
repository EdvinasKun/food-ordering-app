package lt.vtmc.foa.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.models.Menu;
import lt.vtmc.foa.payload.requests.MenuInsertRequest;
import lt.vtmc.foa.payload.requests.MenuUpdateRequest;
import lt.vtmc.foa.payload.responses.MenuResponse;
import lt.vtmc.foa.repositories.EstablishmentRepository;
import lt.vtmc.foa.repositories.MenuRepository;

@Service
public class MenuService {
	
	private final MenuRepository menuRepository;
	private final EstablishmentRepository establishmentRepository;
	
	@Autowired
	public MenuService (MenuRepository menuRepository, EstablishmentRepository establishmentRepository) {
		this.menuRepository = menuRepository;
		this.establishmentRepository = establishmentRepository;
		
	}
	
	public MenuResponse saveMenu(MenuInsertRequest menuRequest) {
		
		Establishment est = establishmentRepository.findById(menuRequest.getEstablishmentId());
		String menuName = menuRequest.getMenuName();
		Menu menu = new Menu(
				
				);
		menu.setMenuName(menuName);
		menu.setEstablishment(est);
		menuRepository.save(menu);
		return new MenuResponse(
				menu.getId().toString(),
				menu.getMenuName(),
				menu.getEstablishment());
		
	}
	public MenuResponse deleteMenu(String id) {
		menuRepository.delete(menuRepository.getById(Long.valueOf(id)));
		return null;
	}
	
	public MenuResponse updateMenu(MenuUpdateRequest menuUpdateRequest) {
		
		Menu updatingMenu = menuRepository.findById(menuUpdateRequest.getMenuId()).get();
		String menuName = menuUpdateRequest.getMenuName();
		String updatingMenuName = menuName.substring(0, 1).toUpperCase() + menuName.substring(1);
		updatingMenu.setMenuName(updatingMenuName);
		//updatingMenu.setEstablishment(establishmentRepository.findById(menuUpdateRequest.getEstablishmentId()));
		menuRepository.save(updatingMenu);
		
		return new MenuResponse(
				updatingMenu.getId().toString(),
				updatingMenuName,
				updatingMenu.getEstablishment()
				);
		
	}
	
	public List<Menu> getAllMenus(){
		return menuRepository.findAll();
	}
	
}
