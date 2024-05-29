package fr.formation.vote.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bureau {
	@Id
	@GeneratedValue
	private Integer idBureau;
	private String numero;
	private String adresse;
	
	@OneToMany
	@ToString.Exclude
	private List<Votant> lstVotants = new ArrayList<>();

	public void addVotant(Votant votant) {
		lstVotants.add(votant);
		votant.setBureau(this);
	}
}
