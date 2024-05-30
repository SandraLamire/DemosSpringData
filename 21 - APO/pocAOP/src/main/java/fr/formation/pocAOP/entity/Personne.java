package fr.formation.pocAOP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personne {
	@Id
	@GeneratedValue
	private Integer idPersonne;
	private String nom;
	private String prenom;
	private Integer age;
	public Personne(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
}
