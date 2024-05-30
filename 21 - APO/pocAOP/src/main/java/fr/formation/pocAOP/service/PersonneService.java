package fr.formation.pocAOP.service;

import java.util.List;

import fr.formation.pocAOP.entity.Personne;

public interface PersonneService {
	public void addPersonne(Personne personne);
	public List<Personne> getPersonnes();
}
