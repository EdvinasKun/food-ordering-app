package lt.vtmc.foa.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishResponse {
	private String dishId;
	private String dishName;
	private String menuName;
}
