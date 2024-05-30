package fr.formation.demoMVCLinkedData.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Maison {
	@Id
	@GeneratedValue
	private Integer idMaison;
	private String adresse;

	public Maison(String adresse) {
		super();
		this.adresse = adresse;
	}

}
