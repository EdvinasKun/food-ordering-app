package lt.vtmc.foa.payload.requests;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MenuInsertRequest {
	
	@NotBlank
	private String menuName;
	
	private String establishmentId;

}
