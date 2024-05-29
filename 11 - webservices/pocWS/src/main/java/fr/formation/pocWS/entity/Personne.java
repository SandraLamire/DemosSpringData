package fr.formation.pocWS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
	private String nom;
	private String prenom;
	private String tel;
}
