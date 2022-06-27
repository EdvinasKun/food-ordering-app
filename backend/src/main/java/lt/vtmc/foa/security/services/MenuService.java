package lt.vtmc.foa.security.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public MenuService(MenuRepository menuRepository, EstablishmentRepository establishmentRepository) {
		this.menuRepository = menuRepository;
		this.establishmentRepository = establishmentRepository;
	}
	
	public MenuResponse saveMenu(MenuInsertRequest menuRequest) {
		
		Menu menu = new Menu(
				
				);
		menu.setMenuName(menuRequest.getMenuName());
		menu.setEstablishment(establishmentRepository.getById(Long.valueOf(menuRequest.getEstablishmentId())));
		menuRepository.save(menu);
		return new MenuResponse(
				menu.getId().toString(),
				menuRequest.getMenuName(),
				menu.getEstablishment().getEstablishmentName()
				);
	}
	public MenuResponse updateMenu(Long id, MenuUpdateRequest menuUpdateRequest) {
		
		Menu updatingMenu = menuRepository.getById(id);
		
		updatingMenu.setMenuName(menuUpdateRequest.getMenuName());
		updatingMenu.setEstablishment(establishmentRepository.getById(Long.valueOf(menuUpdateRequest.getEstablishmentId())));;
		menuRepository.save(updatingMenu);
		return new MenuResponse(
				updatingMenu.getId().toString(),
				updatingMenu.getMenuName(),
				updatingMenu.getEstablishment().getEstablishmentName()
				);
	}
	public MenuResponse deleteMenu(String id) {
		menuRepository.delete(menuRepository.getById(Long.valueOf(id)));
		return null;
	}
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}
	public List<Menu> getAllMenuById(String id){
		return menuRepository.getAllByEstablishmentId(Long.valueOf(id));
	}
}
