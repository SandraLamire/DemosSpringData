package fr.formation.vote.service;

import java.util.List;

import fr.formation.vote.entity.Votant;

public interface VoteService {
	public void voter(Votant votant) throws VoteException;
	public List<Votant> getAll();
	public String winner();
	public Integer moyenneAgeVotants();
	public Integer moyenneAgeVotantsVoteParti(String parti);
}
