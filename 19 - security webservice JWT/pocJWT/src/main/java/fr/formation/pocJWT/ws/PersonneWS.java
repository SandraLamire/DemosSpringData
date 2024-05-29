package fr.formation.pocJWT.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.pocJWT.entity.Personne;
import fr.formation.pocJWT.service.PersonneService;

@RestController
@RequestMapping("/personne")
public class PersonneWS {
	@Autowired
	private PersonneService service;
	
	@GetMapping
	public List<Personne> getAll(){
		return service.getPersonnes();
	}
	
	@PostMapping
	public Personne add(@RequestBody Personne personne) {
		service.addPersonne(personne);
		return personne;
	}
}
