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
public class Personne {
	@Id
	@GeneratedValue
	@JsonView(value= {Views.fromLogements.class,Views.fromHabitants.class})
	private Integer idPersonne;
	@JsonView(value= {Views.fromLogements.class,Views.fromHabitants.class})
	private String nom;
	@JsonView(value= {Views.fromLogements.class,Views.fromHabitants.class})
	private String prenom;

	@ManyToMany(mappedBy = "habitants")
	@Builder.Default
	@Delegate
	@JsonView(Views.fromLogements.class)
	private List<Maison> logements = new ArrayList<>();
}
