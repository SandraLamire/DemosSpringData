package fr.formation.vote.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.vote.entity.Candidat;

public interface CandidatRepository extends CrudRepository<Candidat, Integer>{

}
