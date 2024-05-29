package fr.formation.pocJSONVIEW.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.pocJSONVIEW.bo.Maison;
import fr.formation.pocJSONVIEW.bo.Personne;
import fr.formation.pocJSONVIEW.bo.Views;
import fr.formation.pocJSONVIEW.dal.MaisonDAO;
import fr.formation.pocJSONVIEW.dal.PersonneDAO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@RestController
public class Controller {
	
	@Autowired
	PersonneDAO personneDAO;
	
	@Autowired
	MaisonDAO maisonDAO;

	@PostConstruct
	@Transactional
	private void init() {
		Personne j = Personne.builder().nom("Cérien").prenom("Jean").build();
		Maison m = Maison.builder().nom("Le Lieu").build();
		m.add(j);
		j.add(m);
		personneDAO.save(j);
		maisonDAO.save(m);
	}

	
	@GetMapping("/habitant")
	@JsonView(Views.fromHabitants.class)
	public ResponseEntity<List<Personne>> getPersonnes(){
		return ResponseEntity.ok().body((List<Personne>)personneDAO.findAll());
	}
	
	@GetMapping("/logement")
	@JsonView(Views.fromLogements.class)
	public ResponseEntity<List<Maison>> getLogements(){
		return ResponseEntity.ok().body((List<Maison>) maisonDAO.findAll());
	}
}
