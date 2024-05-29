package fr.formation.pigeon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pigeon {
	@Id
	@GeneratedValue
	private Integer idPigeon;
	private String nom;
	private String proprio;
	private String code;
	public Pigeon(String nom) {
		super();
		this.nom = nom;
	}
	
	
	
}
