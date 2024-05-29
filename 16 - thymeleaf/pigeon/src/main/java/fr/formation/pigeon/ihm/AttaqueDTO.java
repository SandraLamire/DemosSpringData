package fr.formation.pigeon.ihm;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttaqueDTO {
	@Min(value = 0)
	@Max(value = 99)
	private Integer ip;
	@Min(value = 0)
	@Max(value = 9)
	private Integer code;
}
