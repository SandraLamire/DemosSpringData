package fr.formation.vote.entity;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Votant {
	@Id
	@GeneratedValue
	private Integer idVotant;
	private String nom;
	private String prenom;
	private LocalDate ddn;
	@ManyToOne
	private Candidat candidat;
	
	@ManyToOne
	private Bureau bureau;
	
	public Integer getAge() {
		return Period.between(ddn, LocalDate.now()).getYears();
	}
}
