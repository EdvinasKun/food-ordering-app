package lt.vtmc.foa.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishUpdateRequest {
	@NotBlank
	private String dishId;
	
	@NotBlank
	private String dishName;
	
	private String menuId;
}
