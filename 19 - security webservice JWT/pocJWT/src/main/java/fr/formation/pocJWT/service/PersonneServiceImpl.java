package fr.formation.pocJWT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.pocJWT.entity.Personne;
import fr.formation.pocJWT.repository.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService {
	@Autowired
	PersonneRepository repo;
	
	@Override
	public void addPersonne(Personne personne) {
		repo.save(personne);
	}

	@Override
	public List<Personne> getPersonnes() {
		return (List<Personne>) repo.findAll();
	}

}
