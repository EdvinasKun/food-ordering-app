package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MenuUpdateRequest {
	
	@NotBlank
	private Long menuId;
	
	@NotBlank
	private String menuName;
	@NotBlank
	private String establishmentId;
}
