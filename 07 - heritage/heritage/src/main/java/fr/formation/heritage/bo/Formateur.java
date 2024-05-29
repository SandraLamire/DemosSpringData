package fr.formation.heritage.bo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
//@DiscriminatorValue("FORM")
public class Formateur extends Personne {
	private Integer salaire;

	public Formateur(String nom, String prenom, Integer salaire) {
		super(nom, prenom);
		this.salaire=salaire;
	}
	
	
}
