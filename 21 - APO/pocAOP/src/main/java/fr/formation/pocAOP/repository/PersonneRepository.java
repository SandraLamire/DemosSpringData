package fr.formation.pocAOP.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.pocAOP.entity.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{

}
