package fr.formation.contact.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Id
	@GeneratedValue
	private Integer idClient;
	private String nom;
	private String adresse;
	private String ville;
	@OneToMany(mappedBy = "client")
	private List<Etablissement> lstEtablissements = new ArrayList<>();
	
	public Client(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}
	
	public void addEtablissement(Etablissement etablissement) {
		lstEtablissements.add(etablissement);
		etablissement.setClient(this);
	}
	
}
