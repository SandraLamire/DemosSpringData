package fr.formation.heritage.bo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
//@DiscriminatorValue("ETU")
public class Etudiant extends Personne {
	private Integer emprunt;

	public Etudiant(String nom, String prenom, Integer emprunt) {
		super(nom, prenom);
		this.emprunt=emprunt;
	}
	
	
}
