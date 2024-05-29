package fr.formation.pocJWT.service;

import java.util.List;

import fr.formation.pocJWT.entity.Personne;

public interface PersonneService {
	public void addPersonne(Personne personne);
	public List<Personne> getPersonnes();
	
}
