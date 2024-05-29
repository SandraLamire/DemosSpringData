package fr.formation.pocJSONVIEW.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maison {
	@Id
	@GeneratedValue
	@JsonView(value= {Views.fromLogements.class,Views.fromHabitants.class})
	private Integer idMaison;
	@JsonView(value= {Views.fromLogements.class,Views.fromHabitants.class})
	private String nom;
	
	@ManyToMany
	@Builder.Default
	@Delegate
	@JsonView(Views.fromHabitants.class)
	private List<Personne> habitants = new ArrayList<>();
	
}
