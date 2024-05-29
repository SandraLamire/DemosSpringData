package fr.formation.pocDataRest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
	@Id
	@GeneratedValue
	private Integer idPersonne;
	private String nom;
	private String prenom;
}
