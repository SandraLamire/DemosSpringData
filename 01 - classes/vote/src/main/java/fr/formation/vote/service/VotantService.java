package fr.formation.vote.service;

import java.util.List;

import fr.formation.vote.entity.Votant;

public interface VotantService {
	public void voter(Votant votant) throws VotantException;
	public List<Votant> getAll();
	public String winner();
}
