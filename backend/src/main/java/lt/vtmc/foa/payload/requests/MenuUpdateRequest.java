package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vtmc.foa.models.Establishment;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuUpdateRequest {

	@NotBlank
	private String menuId;
	
	@NotBlank
	private String menuName;
	
	private String establishmentId;
}
