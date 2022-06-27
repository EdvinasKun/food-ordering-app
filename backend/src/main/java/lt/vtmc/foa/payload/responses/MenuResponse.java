package lt.vtmc.foa.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vtmc.foa.models.Establishment;
import lt.vtmc.foa.models.Menu;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponse {

	private String menuId;
	private String menuName;
	private String establishmentName;
}
