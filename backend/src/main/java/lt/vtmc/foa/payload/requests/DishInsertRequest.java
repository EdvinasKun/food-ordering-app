package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishInsertRequest {
	@NotBlank
	private String dishName;
	
	@NotBlank
	private String menuId;
}
