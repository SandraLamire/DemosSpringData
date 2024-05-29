package fr.formation.vote.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	private String candidat;
}
