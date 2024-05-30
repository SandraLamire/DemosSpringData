package fr.formation.demoMVCLinkedData.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Personne {
	@Id
	@GeneratedValue
	private Integer idPersonne;
	private String nom;
	private String prenom;

	@ManyToOne
	private Maison maison;

	public Personne(String nom, String prenom, Maison maison) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.maison = maison;
	}

}
